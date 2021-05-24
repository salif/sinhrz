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

import eu.salif.sinhrz.impl.ArgsImpl;
import eu.salif.sinhrz.impl.SinhrzImpl;
import eu.salif.sinhrz.local.EnglishLocal;

public class App {
    public static void main(String[] args) {
    	final Local local = new EnglishLocal();
		try {
			new SinhrzImpl(local, new ArgsImpl(local)).sync();
		} catch (SinhrzException e) {
			System.err.printf("%s: %s%n", local.getError(), e.getLocalizedMessage());
			System.exit(1);
		}
	}
}
