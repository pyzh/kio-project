/*
 * Copyright 2018 MikaGuraNTK
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.nanohttpd.util;

/**
 * Represents a factory that can throw an exception instead of actually creating an object
 *
 * @param <T> The Type of object to create
 * @param <E> The base Type of exceptions that can be thrown
 * @author LordFokas
 */
public interface IFactoryThrowing<T, E extends Throwable> {

	T create() throws E;
}
