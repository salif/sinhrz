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

package eu.salif.sinhrz.local;

import eu.salif.sinhrz.Local;

public class EnglishLocal implements Local {

	@Override
	public String getEnvSinhrzFileName() {
		return "SINHRZ_FILE";
	}

	@Override
	public String getDefaultSinhrzFileName() {
		return ".sinhrz";
	}

	@Override
	public String getEnvSinhrzLockFileName() {
		return "SINHRZ_LOCK_FILE";
	}

	@Override
	public String getDefaultSinhrzLockFileName() {
		return ".lock.sinhrz";
	}

	@Override
	public String getEnvLocalPath() {
		return "SINHRZ_LOCAL";
	}

	@Override
	public String getEnvLocalName() {
		return "SINHRZ_LOCAL_NAME";
	}

	@Override
	public String getDefaultLocalName() {
		return "local";
	}

	@Override
	public String getEnvRemotePath() {
		return "SINHRZ_REMOTE";
	}

	@Override
	public String getEnvRemoteName() {
		return "SINHRZ_REMOTE_NAME";
	}

	@Override
	public String getDefaultRemoteName() {
		return "remote";
	}

	@Override
	public String getEnvInit() {
		return "SINHRZ_INIT";
	}

	@Override
	public String getEnvOneWay() {
		return "SINHRZ_ONE_WAY";
	}

	@Override
	public String getErrorMessage() {
		return "Error";
	}

	@Override
	public String getErrorUnsupportedMessage() {
		return "%s is not supported yet";
	}

	@Override
	public String getErrorStringCanNotBeEmptyMessage() {
		return "%s can not be empty";
	}

	@Override
	public String getErrorStringExistsInsideStringMessage() {
		// TODO better message
		return "%s exists inside %s";
	}

	@Override
	public String getErrorStringDoesNotExistsInsideStringMessage() {
		// TODO better message
		return "%s does not exists inside %s";
	}

	@Override
	public String getErrorStringCanNotBeCreatedMessage() {
		return "%s can not be created";
	}
}
