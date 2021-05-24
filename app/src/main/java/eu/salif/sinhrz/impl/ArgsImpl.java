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

package eu.salif.sinhrz.impl;

import eu.salif.sinhrz.Args;
import eu.salif.sinhrz.Local;
import eu.salif.sinhrz.SinhrzException;

import java.nio.file.Path;

public class ArgsImpl implements Args {
	private Local local;
	private String sinhrzFileName;
	private String sinhrzLockFileName;
	private Path localPath;
	private String localName;
	private Path remotePath;
	private String remoteName;
	private boolean oneWay;
	private boolean init;

	public ArgsImpl(Local local) throws SinhrzException {
		this.setLocal(local);
		this.setSinhrzFileName(getEnv(this.local.getEnvSinhrzFileName(), this.local.getDefaultSinhrzFileName()));
		this.setSinhrzLockFileName(getEnv(this.local.getEnvSinhrzLockFileName(), this.local.getDefaultSinhrzLockFileName()));
		this.setLocalPath(getEnv(this.local.getEnvLocalPath(), ""));
		this.setLocalName(getEnv(this.local.getEnvLocalName(), this.local.getDefaultLocalName()));
		this.setRemotePath(getEnv(this.local.getEnvRemotePath(), ""));
		this.setRemoteName(getEnv(this.local.getEnvRemoteName(), this.local.getDefaultRemoteName()));
		this.setOneWay(System.getenv(this.local.getEnvOneWay()) != null);
		this.setInit(System.getenv(this.local.getEnvInit()) != null);
	}

	private String getEnv(String envName, String defaultValue) {
		String value = System.getenv(envName);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			return value;
		}
	}

	private void setLocal(Local local) {
		if (local == null) {
			throw new NullPointerException();
		}
		this.local = local;
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
	public Path getLocalPath() {
		return localPath;
	}

	private void setLocalPath(String localPath) throws SinhrzException {
		if (localPath.isBlank()) {
			throw new SinhrzException(String.format(this.local.getErrorStringCanNotBeEmptyMessage(),
				this.local.getEnvLocalPath()));
		}
		this.localPath = Path.of(localPath);
	}

	@Override
	public String getLocalName() {
		return localName;
	}

	@Override
	public void setLocalName(String localName) {
		this.localName = localName;
	}

	@Override
	public Path getRemotePath() {
		return remotePath;
	}

	private void setRemotePath(String remotePath) throws SinhrzException {
		if (remotePath.isBlank()) {
			throw new SinhrzException(String.format(this.local.getErrorStringCanNotBeEmptyMessage(),
				this.local.getEnvRemotePath()));
		}
		this.remotePath = Path.of(remotePath);
	}

	@Override
	public String getRemoteName() {
		return remoteName;
	}

	@Override
	public void setRemoteName(String remoteName) {
		this.remoteName = remoteName;
	}

	@Override
	public boolean getOneWay() {
		return oneWay;
	}

	private void setOneWay(boolean oneWay) throws SinhrzException {
		// TODO
		if (oneWay) {
			throw new SinhrzException(String.format(this.local.getErrorUnsupportedMessage(),
				this.local.getEnvOneWay()));
		}
		this.oneWay = oneWay;
	}

	@Override
	public boolean getInit() {
		return init;
	}

	private void setInit(boolean init) {
		this.init = init;
	}
}
