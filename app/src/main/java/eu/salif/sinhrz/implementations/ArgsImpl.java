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

import eu.salif.sinhrz.interfaces.Args;
import eu.salif.sinhrz.interfaces.Localisation;
import eu.salif.sinhrz.errors.SinhrzException;

import java.io.PrintStream;
import java.nio.file.Path;

public class ArgsImpl implements Args {
	private Localisation localisation;
	private PrintStream errStream;
	private PrintStream outStream;
	private String sinhrzFileName;
	private String sinhrzLockFileName;
	private String localLabel;
	private Path localPath;
	private String remoteLabel;
	private Path remotePath;
	private boolean doInit;
	private boolean doVerbose;

	public ArgsImpl(Localisation localisation, PrintStream errStream, PrintStream outStream) throws SinhrzException {
		this.setLocalisation(localisation);
		this.setErrStream(errStream);
		this.setOutStream(outStream);
		this.setSinhrzFileName(getEnv(
			this.localisation.ENV_SINHRZ_FILENAME(),
			this.localisation.DEFAULT_SINHRZ_FILENAME()));
		this.setSinhrzLockFileName(getEnv(
			this.localisation.ENV_SINHRZ_LOCK_FILENAME(),
			this.localisation.DEFAULT_SINHRZ_LOCK_FILENAME()));
		this.setLocalLabel(getEnv(
			this.localisation.ENV_LOCAL_LABEL(),
			this.localisation.DEFAULT_LOCAL_LABEL()));
		this.setLocalPath(getEnv(
			this.localisation.ENV_LOCAL_PATH(),
			""));
		this.setRemoteLabel(getEnv(
			this.localisation.ENV_REMOTE_LABEL(),
			this.localisation.DEFAULT_REMOTE_LABEL()));
		this.setRemotePath(getEnv(
			this.localisation.ENV_REMOTE_PATH(),
			""));
		this.setDoInit(System.getenv(
			this.localisation.ENV_DO_INIT()) != null);
		this.setDoVerbose(System.getenv(
			this.localisation.ENV_DO_VERBOSE()) != null);
	}

	public static String getEnv(String envName, String defaultValue) {
		String value = System.getenv(envName);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			return value;
		}
	}

	@Override
	public Localisation getLocalisation() {
		return localisation;
	}

	private void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	@Override
	public PrintStream getErrStream() {
		return errStream;
	}

	private void setErrStream(PrintStream errStream) {
		this.errStream = errStream;
	}

	@Override
	public PrintStream getOutStream() {
		return outStream;
	}

	private void setOutStream(PrintStream outStream) {
		this.outStream = outStream;
	}

	@Override
	public String getSinhrzFileName() {
		return sinhrzFileName;
	}

	private void setSinhrzFileName(String sinhrzFileName) {
		this.sinhrzFileName = sinhrzFileName;
	}

	@Override
	public String getSinhrzLockFileName() {
		return sinhrzLockFileName;
	}

	private void setSinhrzLockFileName(String sinhrzLockFileName) {
		this.sinhrzLockFileName = sinhrzLockFileName;
	}

	@Override
	public String getLocalLabel() {
		return localLabel;
	}

	private void setLocalLabel(String localLabel) {
		this.localLabel = localLabel;
	}

	@Override
	public Path getLocalPath() {
		return localPath;
	}

	private void setLocalPath(String localPath) throws SinhrzException {
		if (localPath.isBlank()) {
			throw new SinhrzException(this.localisation.ERROR_CAN_NOT_BE_EMPTY(this.localisation.ENV_LOCAL_PATH()));
		}
		this.localPath = Path.of(localPath).normalize();
	}

	@Override
	public String getRemoteLabel() {
		return remoteLabel;
	}

	private void setRemoteLabel(String remoteLabel) {
		this.remoteLabel = remoteLabel;
	}

	@Override
	public Path getRemotePath() {
		return remotePath;
	}

	private void setRemotePath(String remotePath) throws SinhrzException {
		if (remotePath.isBlank()) {
			throw new SinhrzException(this.localisation.ERROR_CAN_NOT_BE_EMPTY(this.localisation.ENV_REMOTE_PATH()));
		}
		this.remotePath = Path.of(remotePath).normalize();
	}

	@Override
	public boolean getDoInit() {
		return doInit;
	}

	private void setDoInit(boolean doInit) {
		this.doInit = doInit;
	}

	@Override
	public boolean getDoVerbose() {
		return doVerbose;
	}

	private void setDoVerbose(boolean doVerbose) {
		this.doVerbose = doVerbose;
	}

}
