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

import eu.salif.sinhrz.implementations.ArgsImpl;
import eu.salif.sinhrz.implementations.SinhrzImpl;
import eu.salif.sinhrz.localisations.BulgarianLocalisation;
import eu.salif.sinhrz.localisations.EnglishLocalisation;

import java.util.Locale;

public class App {
	public static void main(String[] args) {
		Localisation localisation = getLocalisation();
		try {
			new SinhrzImpl(new ArgsImpl(localisation)).sync();
		} catch (SinhrzException e) {
			e.print(localisation);
			System.exit(1);
		}
	}

	private static Localisation getLocalisation() {
		String language = Locale.getDefault().getLanguage();
		if (new Locale("bg").getLanguage().equals(language)) {
			return new BulgarianLocalisation();
		} else {
			return new EnglishLocalisation();
		}
	}
}
