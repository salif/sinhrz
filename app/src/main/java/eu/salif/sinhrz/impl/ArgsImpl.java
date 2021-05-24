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

public class ArgsImpl implements Args {
	private Local local;
	private String sinhrzFileName;
	private String sinhrzLockFileName;
	private String localPath;
	private String localName;
	private String remotePath;
	private String remoteName;
	private boolean isOneWay;

	public ArgsImpl(Local local) throws SinhrzException {
		this.setLocal(local);
		this.init();
	}

	private void init() throws SinhrzException {
		this.setSinhrzFileName(getEnv(this.local.getEnvSinhrzFileName(), this.local.getDefaultSinhrzFileName()));
		this.setSinhrzLockFileName(getEnv(this.local.getEnvSinhrzLockFileName(), this.local.getDefaultSinhrzLockFileName()));
		this.setLocalPath(getEnv(this.local.getEnvLocalPath(), ""));
		this.setLocalName(getEnv(this.local.getEnvLocalName(), this.local.getDefaultLocalName()));
		this.setRemotePath(getEnv(this.local.getEnvRemotePath(), ""));
		this.setRemoteName(getEnv(this.local.getEnvRemoteName(), this.local.getDefaultRemoteName()));
		this.setIsOneWay(System.getenv(this.local.getEnvOneWay()) != null);
	}

	private String getEnv(String envName, String defaultValue) {
		String value = System.getenv(envName);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			return value;
		}
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public String getSinhrzFileName() {
		return sinhrzFileName;
	}

	public void setSinhrzFileName(String sinhrzFileName) {
		this.sinhrzFileName = sinhrzFileName;
	}

	@Override
	public String getSinhrzLockFileName() {
		return sinhrzLockFileName;
	}

	public void setSinhrzLockFileName(String sinhrzLockFileName) {
		this.sinhrzLockFileName = sinhrzLockFileName;
	}

	@Override
	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) throws SinhrzException {
		if (localPath.isBlank()) {
			throw new SinhrzException(String.format(this.local.getErrStringCanNotBeEmpty(), this.local.getEnvLocalPath()));
		}
		this.localPath = localPath;
	}

	@Override
	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	@Override
	public String getRemotePath() {
		return remotePath;
	}

	public void setRemotePath(String remotePath) throws SinhrzException {
		if (remotePath.isBlank()) {
			throw new SinhrzException(String.format(this.local.getErrStringCanNotBeEmpty(), this.local.getEnvRemotePath()));
		}
		this.remotePath = remotePath;
	}

	@Override
	public String getRemoteName() {
		return remoteName;
	}

	public void setRemoteName(String remoteName) {
		this.remoteName = remoteName;
	}

	@Override
	public boolean getIsOneWay() {
		return isOneWay;
	}

	public void setIsOneWay(boolean isOneWay) {
		this.isOneWay = isOneWay;
	}
}
