package com.totalcross;

import totalcross.ui.MainWindow;
import totalcross.ui.dialog.KeyboardBox;
import totalcross.ui.dialog.keyboard.KeyboardEdit;
import totalcross.ui.dialog.keyboard.VirtualKeyboard;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;

import jdkcompat.lang.Runtime4D;
import totalcross.sys.Settings;
import totalcross.sys.Vm;
import totalcross.io.ByteArrayStream;
import totalcross.io.File;
import totalcross.ni.*;

public class TCNIApp extends MainWindow {

    public TCNIApp() {
        setUIStyle(Settings.MATERIAL_UI);
    }

    public void loadLibraryTest() {
        testException("Should throw execption lib not found",
                () -> Runtime.getRuntime().loadLibrary("non-existing-lib"));
        testException("Should throw execption null pointer", () -> Runtime.getRuntime().loadLibrary(null));
        Runtime.getRuntime().loadLibrary("hello");
    }

    public void testException(String message, Action action) {
        try {
            System.out.println("=== testing === : ");
            System.out.println("name: " + message);
            System.out.print("result: ");
            action.execute();
            System.out.println(" - failed");
        } catch (Exception e) {
            System.out.println(" - passed");
            System.out.println("error message: " + e.getMessage());
        }
    }

    public interface Action {
        public void execute();
    }

    @Override
    public void initUI() {

        loadLibraryTest();
        testException("Should throw execption lib not found",
                () -> TCNI.invokeMethod("non-existinglib", "hello", void.class));

        testException("Should throw symbol not found for libhello.so",
                () -> TCNI.invokeMethod("hello", "nonExistingMethod", void.class));
        testException("Should throw null pointer exception for method",
                () -> TCNI.invokeMethod("hello", null, void.class));
        testException("Should throw null pointer exception for module",
                () -> TCNI.invokeMethod(null, "hello", void.class));

        TCNI.invokeMethod("hello", "hello", Void.class, "Italo", 0.5, 0.1f, 1);
        TCNI.invokeMethod("hello", "hello", void.class, "Italo", 0.5, 0.1f, 1);
        TCNI.invokeMethod("hello", "hello", Integer.class, "Italo", 0.5, 0.1f, 1);

        TCNI.invokeMethod("hello", "helloDouble", Double.class, "Italo", 0.5, 0.1f, 1);
        // System.out.println("value of double: " + d);
        float f = (Float) TCNI.invokeMethod("hello", "helloFloat", Float.class, "Italo", 0.5, 0.1f, 1);
        System.out.println("value of float: " + f);
        String s = (String) TCNI.invokeMethod("hello", "helloStr", String.class, "Italo", 0.5, 0.1f, 1);
        System.out.println("value of string: " + s);
        int i = (Integer) TCNI.invokeMethod("hello", "helloInt", Integer.class, "Italo", 0.5, 0.1f, 1);
        System.out.println("value of int: " + i);

        int[] intArray = (int[]) TCNI.invokeMethod("hello", "helloIntArray", int[].class);
        System.out.print("java array: ");
        for (int j = 0; j < intArray.length; j++) {
            System.out.print(intArray[j] + " ");
        }
        System.out.println();
        
        char c = (char) TCNI.invokeMethod("hello", "helloChar", Character.class, 'c');
        System.out.println("value of char: " + c);
        long li = (long) TCNI.invokeMethod("hello", "helloLong", Long.class, (long) 10000);
        System.out.println("value of long: " + li);
        short si = (short) TCNI.invokeMethod("hello", "helloShort", Short.class, (short) 30);
        System.out.println("value of si: " + si);
        byte by = (byte) TCNI.invokeMethod("hello", "helloByte", Byte.class, (byte) 40);
        System.out.println("value of byte: " + by);
        boolean bo = (boolean) TCNI.invokeMethod("hello", "helloBoolean", Boolean.class, true);
        System.out.println("value of boolean: " + bo);

        // extern char helloChar(char * name, double dValue, float fValue, int iValue,
        // char c, long int li, short int si, unsigned short int by, bool bo);

        // extern long int helloLong(char * name, double dValue, float fValue, int
        // iValue, char c, long int li, short int si, unsigned short int by, bool bo);

        // extern short int helloShort(char * name, double dValue, float fValue, int
        // iValue, char c, long int li, short int si, unsigned short int by, bool bo);

        // extern unsigned short int helloByte(char * name, double dValue, float fValue,
        // int iValue, char c, long int li, short int si, unsigned short int by, bool
        // bo);

        // extern bool helloBoolean(char * name, double dValue, float fValue, int
        // iValue, char c, long int li, short int si, unsigned short int by, bool bo);

    }

}
