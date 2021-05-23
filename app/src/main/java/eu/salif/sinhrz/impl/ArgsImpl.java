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
import eu.salif.sinhrz.Const;

public class ArgsImpl implements Args {
	private String sinhrzFileName;
	private String sinhrzLockFileName;
	private String local;
	private String localName;
	private String remote;
	private String remoteName;
	private boolean isOneWay;

	public ArgsImpl() {
		this.setSinhrzFileName(getEnv(Const.ENV_SINHRZ_FILE, Const.DEFAULT_SINHRZ_FILE));
		this.setSinhrzLockFileName(getEnv(Const.ENV_SINHRZ_LOCK_FILE, Const.DEFAULT_SINHRZ_LOCK_FILE));
		this.setLocal(getEnv(Const.ENV_LOCAL, Const.DEFAULT_LOCAL));
		this.setLocalName(getEnv(Const.ENV_LOCAL_NAME, Const.DEFAULT_LOCAL_NAME));
		this.setRemote(getEnv(Const.ENV_REMOTE, Const.DEFAULT_REMOTE));
		this.setRemoteName(getEnv(Const.ENV_REMOTE_NAME, Const.DEFAULT_REMOTE_NAME));
		this.setIsOneWay(System.getenv(Const.ENV_ONE_WAY) != null);
	}

	private String getEnv(String envName, String defaultValue) {
		String value = System.getenv(envName);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			return value;
		}
	}

	public String getSinhrzFileName() {
		return sinhrzFileName;
	}

	public void setSinhrzFileName(String sinhrzFileName) {
		this.sinhrzFileName = sinhrzFileName;
	}

	public String getSinhrzLockFileName() {
		return sinhrzLockFileName;
	}

	public void setSinhrzLockFileName(String sinhrzLockFileName) {
		this.sinhrzLockFileName = sinhrzLockFileName;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getRemote() {
		return remote;
	}

	public void setRemote(String remote) {
		this.remote = remote;
	}

	public String getRemoteName() {
		return remoteName;
	}

	public void setRemoteName(String remoteName) {
		this.remoteName = remoteName;
	}

	public boolean getIsOneWay() {
		return isOneWay;
	}

	public void setIsOneWay(boolean isOneWay) {
		this.isOneWay = isOneWay;
	}
}
