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

	public String NAME() {
		return "Sinhrz";
	}

	public abstract String LOC_NAME();

	public String ENV_SINHRZ_FILENAME() {
		return "SINHRZ_FILENAME";
	}

	public String DEFAULT_SINHRZ_FILENAME() {
		return ".sinhrz";
	}

	public abstract String GUI_SINHRZ_FILENAME();

	public String ENV_SINHRZ_LOCK_FILENAME() {
		return "SINHRZ_LOCK_FILENAME";
	}

	public String DEFAULT_SINHRZ_LOCK_FILENAME() {
		return ".lock.sinhrz";
	}

	public abstract String GUI_SINHRZ_LOCK_FILENAME();

	public String ENV_LOCAL_LABEL() {
		return "SINHRZ_LOCAL_LABEL";
	}

	public abstract String DEFAULT_LOCAL_LABEL();

	public abstract String GUI_LOCAL_LABEL();

	public String ENV_LOCAL_PATH() {
		return "SINHRZ_LOCAL_PATH";
	}

	public abstract String GUI_LOCAL_PATH();

	public String ENV_REMOTE_LABEL() {
		return "SINHRZ_REMOTE_LABEL";
	}

	public abstract String DEFAULT_REMOTE_LABEL();

	public abstract String GUI_REMOTE_LABEL();

	public String ENV_REMOTE_PATH() {
		return "SINHRZ_REMOTE_PATH";
	}

	public abstract String GUI_REMOTE_PATH();

	public String ENV_DO_INIT() {
		return "SINHRZ_INIT";
	}

	public abstract String GUI_DO_INIT();

	public String ENV_DO_VERBOSE() {
		return "SINHRZ_VERBOSE";
	}

	public abstract String GUI_DO_VERBOSE();

	public abstract String SYNC_MESSAGE();

	public abstract String ERROR_MESSAGE();

	public abstract String WARNING_MESSAGE();

	public abstract String INFO_DELETED_AND_COPIED(int sd, String sn, int ss, String sf, String st);

	public abstract String INFO_DELETING_FROM(String s, String f);

	public abstract String INFO_COPYING_FROM_TO(String s, String f, String t);

	public abstract String ERROR_IS_NOT_INIT(String s);

	public abstract String ERROR_CAN_NOT_BE_EMPTY(String s);

	public abstract String ERROR_DOES_NOT_EXIST(String s);

	public abstract String ERROR_IS_LOCKED(String s, String n);

	public abstract String ERROR_CAN_NOT_BE_CREATED(String s, String m);

	public abstract String ERROR_CAN_NOT_CREATE_LOCK_FILE_IN(String s, String m);

	public abstract String ERROR_CAN_NOT_DELETE_LOCK_FILE_IN(String s, String m);
}
