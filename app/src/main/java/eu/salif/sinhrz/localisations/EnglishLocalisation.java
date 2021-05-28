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

import eu.salif.sinhrz.interfaces.Localisation;

public class EnglishLocalisation extends Localisation {

	@Override
	public String LOC_NAME() {
		return "Synchronizer";
	}

	@Override
	public String GUI_SINHRZ_FILENAME() {
		return "Sinhrz file name";
	}

	@Override
	public String GUI_SINHRZ_LOCK_FILENAME() {
		return "Sinhrz lock file name";
	}

	@Override
	public String DEFAULT_LOCAL_LABEL() {
		return "local";
	}

	@Override
	public String GUI_LOCAL_LABEL() {
		return "Local directory label";
	}

	@Override
	public String GUI_LOCAL_PATH() {
		return "Local directory path";
	}

	@Override
	public String DEFAULT_REMOTE_LABEL() {
		return "remote";
	}

	@Override
	public String GUI_REMOTE_LABEL() {
		return "Remote directory label";
	}

	@Override
	public String GUI_REMOTE_PATH() {
		return "Remote directory path";
	}

	@Override
	public String GUI_DO_INIT() {
		return "Initialize";
	}

	@Override
	public String GUI_DO_VERBOSE() {
		return "Verbose logging";
	}

	@Override
	public String SYNC_MESSAGE() {
		return "sync";
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
	public String INFO_DELETED_AND_COPIED(int sd, String sn, int ss, String sf, String st) {
		return String.format("%s files deleted from '%s'%n%s files copied from '%s' to '%s'%n", sd, sn, ss, sf, st);
	}

	@Override
	public String INFO_DELETING_FROM(String s, String f) {
		return String.format("deleting '%s' from '%s'%n", s, f);
	}

	@Override
	public String INFO_COPYING_FROM_TO(String s, String f, String t) {
		return String.format("copying '%s' from '%s' to '%s'%n", s, f, t);
	}

	@Override
	public String ERROR_IS_NOT_INIT(String s) {
		return String.format("'%s' is not initialized", s);
	}

	@Override
	public String ERROR_CAN_NOT_BE_EMPTY(String s) {
		return String.format("'%s' can not be empty", s);
	}

	@Override
	public String ERROR_DOES_NOT_EXIST(String s) {
		return String.format("'%s' does not exist", s);
	}

	@Override
	public String ERROR_IS_LOCKED(String s, String n) {
		return String.format("'%s' is locked, needs manually deleting the lock file '%s'", s, n);
	}

	@Override
	public String ERROR_CAN_NOT_BE_CREATED(String s, String m) {
		return String.format("'%s' can not be created%n%s", s, m);
	}

	@Override
	public String ERROR_CAN_NOT_CREATE_LOCK_FILE_IN(String s, String m) {
		return String.format("can not create lock file in '%s'%n%s", s, m);
	}

	@Override
	public String ERROR_CAN_NOT_DELETE_LOCK_FILE_IN(String s, String m) {
		return String.format("can not delete lock file in '%s'%n%s", s, m);
	}
}
