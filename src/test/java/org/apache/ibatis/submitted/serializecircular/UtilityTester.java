/**
 * Copyright 2009-2015 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.submitted.serializecircular;

import java.io.*;

public class UtilityTester {

    public static void serializeAndDeserializeObject(Object myObject) {

        try {
            deserialzeObject(serializeObject(myObject));
        } catch (IOException e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    private static byte[] serializeObject(Object myObject) throws IOException {
        try {
            ByteArrayOutputStream myByteArrayOutputStream = new ByteArrayOutputStream();

            // Serialize to a byte array
            ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myByteArrayOutputStream);
            myObjectOutputStream.writeObject(myObject);
            myObjectOutputStream.close();

            // Get the bytes of the serialized object
            byte[] myResult = myByteArrayOutputStream.toByteArray();
            return myResult;
        } catch (Exception anException) {
            throw new RuntimeException("Problem serializing: " + anException.toString(), anException);
        }
    }

    private static Object deserialzeObject(byte[] aSerializedObject) {
        try {
            // Deserialize from a byte array
            ObjectInputStream myObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(aSerializedObject));
            Object myResult = myObjectInputStream.readObject();
            myObjectInputStream.close();

            return myResult;
        } catch (Exception anException) {
            throw new RuntimeException("Problem deserializing", anException);
        }
    }

}
