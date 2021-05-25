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
	public String DEFAULT_LOCAL_NAME() {
		return "локална директория";
	}

	@Override
	public String DEFAULT_REMOTE_NAME() {
		return "отдалечена директория";
	}

	@Override
	public String ERROR_MESSAGE() {
		return "Грешка";
	}

	@Override
	public String ERROR_UNSUPPORTED() {
		return "%s все още не се поддържа";
	}

	@Override
	public String ERROR_STRING_CAN_NOT_BE_EMPTY() {
		return "%s не може да бъде празно";
	}

	@Override
	public String ERROR_STRING_EXISTS_INSIDE_STRING() {
		return "%s съществува в %s";
	}

	@Override
	public String ERROR_STRING_DOES_NOT_EXISTS_INSIDE_STRING() {
		return "%s не съществува в %s";
	}

	@Override
	public String ERROR_STRING_CAN_NOT_BE_CREATED() {
		return "%s не може да бъде създадено";
	}
}
