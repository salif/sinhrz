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

package eu.salif.sinhrz;

public abstract class Localisation {
	public abstract String DEFAULT_LOCAL_NAME();

	public abstract String DEFAULT_REMOTE_NAME();

	public abstract String ERROR_MESSAGE();

	public abstract String ERROR_UNSUPPORTED();

	public abstract String ERROR_STRING_CAN_NOT_BE_EMPTY();

	public abstract String ERROR_STRING_EXISTS_INSIDE_STRING();

	public abstract String ERROR_STRING_DOES_NOT_EXISTS_INSIDE_STRING();

	public abstract String ERROR_STRING_CAN_NOT_BE_CREATED();

	public String ENV_SINHRZ_FILENAME() {
		return "SINHRZ_FILE";
	}

	public String DEFAULT_SINHRZ_FILENAME() {
		return ".sinhrz";
	}

	public String ENV_SINHRZ_LOCK_FILENAME() {
		return "SINHRZ_LOCK_FILE";
	}

	public String DEFAULT_SINHRZ_LOCK_FILENAME() {
		return ".lock.sinhrz";
	}

	public String ENV_LOCAL_PATH() {
		return "SINHRZ_LOCAL";
	}

	public String ENV_LOCAL_NAME() {
		return "SINHRZ_LOCAL_NAME";
	}

	public String ENV_REMOTE_PATH() {
		return "SINHRZ_REMOTE";
	}

	public String ENV_REMOTE_NAME() {
		return "SINHRZ_REMOTE_NAME";
	}

	public String ENV_INIT() {
		return "SINHRZ_INIT";
	}

	public String ENV_ONE_WAY() {
		return "SINHRZ_ONE_WAY";
	}
}
