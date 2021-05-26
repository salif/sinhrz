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
import eu.salif.sinhrz.Localisation;
import eu.salif.sinhrz.SinhrzException;

import java.nio.file.Path;

public class ArgsImpl implements Args {
	private Localisation localisation;
	private String sinhrzFileName;
	private String sinhrzLockFileName;
	private Path localPath;
	private String localName;
	private Path remotePath;
	private String remoteName;
	private boolean init;

	public ArgsImpl(Localisation localisation) throws SinhrzException {
		this.setLocalisation(localisation);
		this.setSinhrzFileName(getEnv(
			this.localisation.ENV_SINHRZ_FILENAME(),
			this.localisation.DEFAULT_SINHRZ_FILENAME()));
		this.setSinhrzLockFileName(getEnv(
			this.localisation.ENV_SINHRZ_LOCK_FILENAME(),
			this.localisation.DEFAULT_SINHRZ_LOCK_FILENAME()));
		this.setLocalPath(getEnv(
			this.localisation.ENV_LOCAL_PATH(),
			""));
		this.setLocalName(getEnv(
			this.localisation.ENV_LOCAL_NAME(),
			this.localisation.DEFAULT_LOCAL_NAME()));
		this.setRemotePath(getEnv(
			this.localisation.ENV_REMOTE_PATH(),
			""));
		this.setRemoteName(getEnv(
			this.localisation.ENV_REMOTE_NAME(),
			this.localisation.DEFAULT_REMOTE_NAME()));
		this.setInit(System.getenv(
			this.localisation.ENV_INIT()) != null);
	}

	private String getEnv(String envName, String defaultValue) {
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
			throw new SinhrzException(this.localisation.ERROR_CAN_NOT_BE_EMPTY(this.localisation.ENV_LOCAL_PATH()));
		}
		this.localPath = Path.of(localPath).normalize();
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
			throw new SinhrzException(this.localisation.ERROR_CAN_NOT_BE_EMPTY(this.localisation.ENV_REMOTE_PATH()));
		}
		this.remotePath = Path.of(remotePath).normalize();
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
	public boolean getInit() {
		return init;
	}

	private void setInit(boolean init) {
		this.init = init;
	}
}
