package io.github.droidkaigi.confsched.util;

import android.content.Context;
import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static org.junit.Assert.*;

/**
 * Created by appdojo on 2016/02/18.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(packageName = "io.github.droidkaigi.confsched")
public class IntentUtilTest {

    @Test
    public void testShare() throws Exception {
        ShadowApplication shadowApplication = ShadowApplication.getInstance();
        Context context = shadowApplication.getApplicationContext();

        IntentUtil.share(context, "https://mixi.co.jp/");
        Intent intent = shadowApplication.getNextStartedActivity();
        Intent targetIntent = intent.getParcelableExtra(Intent.EXTRA_INTENT);
        assertEquals("https://mixi.co.jp/ #droidkaigi",
                targetIntent.getStringExtra(Intent.EXTRA_TEXT));
    }
}