package com.example.matchwords

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GridLayoutTest::class,
    MainActivityTest::class
)
class ActivitySuite