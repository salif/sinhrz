/*
 * Copyright 2021 Salif Mehmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.salif.sinhrz.implementations;

import eu.salif.sinhrz.Args;
import eu.salif.sinhrz.Sinhrz;
import eu.salif.sinhrz.SinhrzException;
import eu.salif.sinhrz.SinhrzWarning;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SinhrzImpl implements Sinhrz {
	private Args args;
	private SinhrzPaths paths;
	private FileNameFilter fileNameFilter;

	public SinhrzImpl() {
	}

	@Override
	public void setArgs(Args args) throws SinhrzException {
		this.args = args;
		this.setPaths();
		this.validateArgs();
		this.setFileNameFilter(new FileNameFilter(this.args.getSinhrzFileName(), this.args.getSinhrzLockFileName()));
	}

	private void setPaths() {
		this.paths = new SinhrzPaths(
			this.args.getLocalPath().resolve(this.args.getSinhrzFileName()),
			this.args.getLocalPath().resolve(this.args.getSinhrzLockFileName()),
			this.args.getRemotePath().resolve(this.args.getSinhrzLockFileName())
		);
	}

	private void setFileNameFilter(FileNameFilter fileNameFilter) {
		this.fileNameFilter = fileNameFilter;
	}

	private void validateArgs() throws SinhrzException {
		if (!Files.isDirectory(this.args.getLocalPath())) {
			throw new SinhrzException(this.args.getLocalisation().ERROR_DOES_NOT_EXIST(
				this.args.getLocalPath().toString()));
		}
		if (!Files.isDirectory(this.args.getRemotePath())) {
			throw new SinhrzException(this.args.getLocalisation().ERROR_DOES_NOT_EXIST(
				this.args.getRemotePath().toString()));
		}
		if (Files.exists(this.paths.getLocalLockFilePath())) {
			throw new SinhrzException(this.args.getLocalisation().ERROR_IS_LOCKED(
				this.args.getLocalLabel(), this.paths.getLocalLockFilePath().toString()));
		}
		if (Files.exists(this.paths.getRemoteLockFilePath())) {
			throw new SinhrzException(this.args.getLocalisation().ERROR_IS_LOCKED(
				this.args.getRemoteLabel(), this.paths.getRemoteLockFilePath().toString()));
		}
		if (!Files.exists(this.paths.getLocalSinhrzFilePath())) {
			if (this.args.getDoInit()) {
				try {
					Files.createFile(this.paths.getLocalSinhrzFilePath());
				} catch (IOException e) {
					throw new SinhrzException(this.args.getLocalisation().ERROR_CAN_NOT_BE_CREATED(
						this.paths.getLocalSinhrzFilePath().toString(), e.toString()));
				}
			} else {
				throw new SinhrzException(this.args.getLocalisation().ERROR_IS_NOT_INIT(this.args.getLocalLabel()));
			}
		}
	}

	private void lock() throws SinhrzException {
		try {
			Files.createFile(this.paths.getLocalLockFilePath());
		} catch (IOException e) {
			throw new SinhrzException(this.args.getLocalisation().ERROR_CAN_NOT_CREATE_LOCK_FILE_IN(
				this.args.getLocalLabel(), e.toString()));
		}
		try {
			Files.createFile(this.paths.getRemoteLockFilePath());
		} catch (IOException e) {
			throw new SinhrzException(this.args.getLocalisation().ERROR_CAN_NOT_CREATE_LOCK_FILE_IN(
				this.args.getRemoteLabel(), e.toString()));
		}
	}

	private void unlock() {
		try {
			Files.delete(this.paths.getLocalLockFilePath());
		} catch (IOException e) {
			new SinhrzWarning(this.args.getLocalisation().ERROR_CAN_NOT_DELETE_LOCK_FILE_IN(
				this.args.getLocalLabel(), e.toString())).print(this.args.getLocalisation(), this.args.getErrStream());
		}
		try {
			Files.delete(this.paths.getRemoteLockFilePath());
		} catch (IOException e) {
			new SinhrzWarning(this.args.getLocalisation().ERROR_CAN_NOT_DELETE_LOCK_FILE_IN(
				this.args.getRemoteLabel(), e.toString())).print(this.args.getLocalisation(), this.args.getErrStream());
		}
	}

	private Set<String> list(File f, Path p) {
		Set<String> result = new TreeSet<>();
		File[] files = f.listFiles(this.fileNameFilter);
		if (files == null) {
			return result;
		} else {
			for (File file : files) {
				result.add(p.resolve(file.getName()).toString());
				if (file.isDirectory()) {
					result.addAll(list(file, p.resolve(file.getName())));
				}
			}
		}
		return result;
	}

	@Override
	public boolean sync() throws SinhrzException {
		this.lock();
		try {
			List<String> sinhrzFiles = Files.readAllLines(this.paths.getLocalSinhrzFilePath());
			Set<String> localFiles = list(this.args.getLocalPath().toFile(), Path.of(""));
			Set<String> remoteFiles = list(this.args.getRemotePath().toFile(), Path.of(""));
			Set<String> syncedFiles = new TreeSet<>(localFiles);
			syncedFiles.retainAll(remoteFiles);
			localFiles.removeAll(syncedFiles);
			remoteFiles.removeAll(syncedFiles);
			int filesDeletedFromLocal = 0;
			int filesSentFromLocalToRemote = 0;
			int filesDeletedFromRemote = 0;
			int filesSentFromRemoteToLocal = 0;
			for (String localFile : localFiles) {
				if (sinhrzFiles.contains(localFile)) {
					Files.delete(this.args.getLocalPath().resolve(localFile));
					filesDeletedFromLocal += 1;
				} else {
					Files.copy(this.args.getLocalPath().resolve(localFile),
						this.args.getRemotePath().resolve(localFile));
					filesSentFromLocalToRemote += 1;
				}
			}
			for (String remoteFile : remoteFiles) {
				if (sinhrzFiles.contains(remoteFile)) {
					Files.delete(this.args.getRemotePath().resolve(remoteFile));
					filesDeletedFromRemote += 1;
				} else {
					Files.copy(this.args.getRemotePath().resolve(remoteFile),
						this.args.getLocalPath().resolve(remoteFile));
					filesSentFromRemoteToLocal += 1;
				}
			}
			Set<String> newSinhrzFileContent = list(this.args.getLocalPath().toFile(), Path.of(""));
			Files.write(this.paths.getLocalSinhrzFilePath(), newSinhrzFileContent, StandardCharsets.UTF_8);
			this.args.getOutStream().print(this.args.getLocalisation().INFO_DELETED_AND_SENT(
				filesDeletedFromLocal, this.args.getLocalLabel(),
				filesSentFromLocalToRemote, this.args.getLocalLabel(), this.args.getRemoteLabel()));
			this.args.getOutStream().print(this.args.getLocalisation().INFO_DELETED_AND_SENT(
				filesDeletedFromRemote, this.args.getRemoteLabel(),
				filesSentFromRemoteToLocal, this.args.getRemoteLabel(), this.args.getLocalLabel()));
		} catch (IOException e) {
			throw new SinhrzException(e.getLocalizedMessage());
		}
		this.unlock();
		return true;
	}
}
