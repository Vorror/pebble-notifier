/* 
Copyright (c) 2013 Dattas Moonchaser

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.dattasmoon.pebble.plugin;

import android.content.Context;
import android.util.Log;

public final class Constants {

    public static final String  LOG_TAG                              = "com.dattasmoon.pebble.plugin";
    public static final boolean IS_LOGGABLE                          = BuildConfig.DEBUG;
    public static final String  DONATION_URL                         = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=3W6PJ6EK6JVJY";

    // bundle extras
    public static final String  BUNDLE_EXTRA_INT_VERSION_CODE        = LOG_TAG + ".INT_VERSION_CODE";
    public static final String  BUNDLE_EXTRA_STRING_TITLE            = LOG_TAG + ".STRING_TITLE";
    public static final String  BUNDLE_EXTRA_STRING_BODY             = LOG_TAG + ".STRING_BODY";
    public static final String  BUNDLE_EXTRA_INT_TYPE                = LOG_TAG + ".INT_TYPE";
    public static final String  BUNDLE_EXTRA_INT_MODE                = LOG_TAG + ".INT_MODE";
    public static final String  BUNDLE_EXTRA_BOOL_NOTIFICATIONS_ONLY = LOG_TAG + ".BOOL_NOTIFICATIONS_ONLY";
    public static final String  BUNDLE_EXTRA_STRING_PACKAGE_LIST     = LOG_TAG + ".STRING_PACKAGE_LIST";

    // Tasker bundle extras
    public static final String  BUNDLE_EXTRA_REPLACE_KEY             = "net.dinglisch.android.tasker.extras.VARIABLE_REPLACE_KEYS";
    public static final String  BUNDLE_EXTRA_REPLACE_VALUE           = BUNDLE_EXTRA_STRING_TITLE + " "
                                                                             + BUNDLE_EXTRA_STRING_BODY;

    // Shared preferences
    public static final String  PREFERENCE_EXCLUDE_MODE              = LOG_TAG + ".excludeMode";
    public static final String  PREFERENCE_MODE                      = LOG_TAG + ".mode";
    public static final String  PREFERENCE_NOTIFICATIONS_ONLY        = LOG_TAG + ".notificationsOnly";
    public static final String  PREFERENCE_PACKAGE_LIST              = LOG_TAG + ".packageList";
    public static final String  PREFERENCE_MIN_NOTIFICATION_WAIT     = LOG_TAG + ".minNotificationWait";
    public static final String  PREFERENCE_TASKER_SET                = LOG_TAG + ".taskerSet";

    // Intents
    public static final String  INTENT_SEND_PEBBLE_NOTIFICATION      = "com.getpebble.action.SEND_NOTIFICATION";

    // Pebble specific items
    public static final String  PEBBLE_MESSAGE_TYPE_ALERT            = "PEBBLE_ALERT";

    // Accessibility specific items
    public static final String  ACCESSIBILITY_SERVICE                = "com.dattasmoon.pebble.plugin/com.dattasmoon.pebble.plugin.NotificationService";

    public static enum Type {
        NOTIFICATION, SETTINGS
    };

    public static enum Mode {
        OFF, EXCLUDE, INCLUDE
    }

    public static int getVersionCode(final Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (final UnsupportedOperationException e) {
            return 1;
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void log(String message) {
        if (Constants.IS_LOGGABLE) {
            Log.d(LOG_TAG, message);
        }
    }

    private Constants() {
        throw new UnsupportedOperationException("This class is non-instantiable, so stop trying!");
    }
}
