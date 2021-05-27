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

public class BulgarianLocalisation extends Localisation {
	@Override
	public String LOC_NAME() {
		return "Синхронизатор";
	}

	@Override
	public String GUI_SINHRZ_FILENAME() {
		return "Име на синхронизиращия файл";
	}

	@Override
	public String GUI_SINHRZ_LOCK_FILENAME() {
		return "Име на заключващия файл";
	}

	@Override
	public String DEFAULT_LOCAL_LABEL() {
		return "локална директория";
	}

	@Override
	public String GUI_LOCAL_LABEL() {
		return "Име на локалн. директория";
	}

	@Override
	public String GUI_LOCAL_PATH() {
		return "Път към локалн. директория";
	}

	@Override
	public String DEFAULT_REMOTE_LABEL() {
		return "отдалечен. директория";
	}

	@Override
	public String GUI_REMOTE_LABEL() {
		return "Име на отдалечен. директория";
	}

	@Override
	public String GUI_REMOTE_PATH() {
		return "Път към отдалечен. директория";
	}

	@Override
	public String GUI_DO_INIT() {
		return "Инициализиране";
	}

	@Override
	public String GUI_DO_VERBOSE() {
		return "Подробен отчет";
	}

	@Override
	public String SYNC_MESSAGE() {
		return "синхронизирай";
	}

	@Override
	public String ERROR_MESSAGE() {
		return "Грешка";
	}

	@Override
	public String WARNING_MESSAGE() {
		return "Предупреждение";
	}

	@Override
	public String INFO_DELETED_AND_COPIED(int sd, String sn, int ss, String sf, String st) {
		return String.format("%s файла изтрити от '%s'%n%s файла копирани от '%s' до '%s'%n", sd, sn, ss, sf, st);
	}

	@Override
	public String INFO_DELETING_FROM(String s, String f) {
		return String.format("изтриване на '%s' от '%s'%n", s, f);
	}

	@Override
	public String INFO_COPYING_FROM_TO(String s, String f, String t) {
		return String.format("копиране на '%s' от '%s' към '%s'%n", s, f, t);
	}

	@Override
	public String ERROR_IS_NOT_INIT(String s) {
		return String.format("'%s' не е инициализирано", s);
	}

	@Override
	public String ERROR_CAN_NOT_BE_EMPTY(String s) {
		return String.format("'%s' не може да бъде празно", s);
	}

	@Override
	public String ERROR_DOES_NOT_EXIST(String s) {
		return String.format("'%s' не съществува", s);
	}

	@Override
	public String ERROR_IS_LOCKED(String s, String n) {
		return String.format("'%s' е заключено, нужно е ръчно изтриване на заключващия файл '%s'", s, n);
	}

	@Override
	public String ERROR_CAN_NOT_BE_CREATED(String s, String m) {
		return String.format("'%s' не може да бъде създадено%n%s", s, m);
	}

	@Override
	public String ERROR_CAN_NOT_CREATE_LOCK_FILE_IN(String s, String m) {
		return String.format("неуспешно заключване на '%s'%n%s", s, m);
	}

	@Override
	public String ERROR_CAN_NOT_DELETE_LOCK_FILE_IN(String s, String m) {
		return String.format("неуспешно отключване на '%s'%n%s", s, m);
	}
}
