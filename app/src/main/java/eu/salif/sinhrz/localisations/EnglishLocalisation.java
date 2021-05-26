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

package eu.salif.sinhrz.localisations;

import eu.salif.sinhrz.Localisation;

public class EnglishLocalisation extends Localisation {
	@Override
	public String DEFAULT_LOCAL_NAME() {
		return "local directory";
	}

	@Override
	public String DEFAULT_REMOTE_NAME() {
		return "remote directory";
	}

	@Override
	public String ERROR_MESSAGE() {
		return "Error";
	}

	@Override
	public String WARNING_MESSAGE() {
		return "Warning";
	}

	@Override
	public String ERROR_IS_NOT_SUPPORTED_YET(String s) {
		return String.format("%s is not supported yet", s);
	}

	@Override
	public String ERROR_IS_NOT_INIT(String s) {
		return String.format("%s is not initialized", s);
	}

	@Override
	public String ERROR_CAN_NOT_BE_EMPTY(String s) {
		return String.format("%s can not be empty", s);
	}

	@Override
	public String ERROR_DOES_NOT_EXIST(String s) {
		return String.format("%s does not exist", s);
	}

	@Override
	public String ERROR_IS_LOCKED(String s, String n) {
		return String.format("%s is locked, needs manually deleting the lock file %s", s, n);
	}

	@Override
	public String ERROR_CAN_NOT_BE_CREATED(String s, String m) {
		return String.format("%s can not be created%n%s", s, m);
	}

	@Override
	public String ERROR_CAN_NOT_CREATE_LOCK_FILE_IN(String s, String m) {
		return String.format("can not create lock file in %s%n%s", s, m);
	}

	@Override
	public String ERROR_CAN_NOT_DELETE_LOCK_FILE_IN(String s, String m) {
		return String.format("can not delete lock file in %s%n%s", s, m);
	}
}
