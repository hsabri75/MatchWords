package com.example.matchwords.mvc

import com.example.matchwords.mvc.model.AbstractModelTest
import com.example.matchwords.mvc.model.SwappableModelTest
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
    AbstractModelTest::class,
    SwappableModelTest::class
)
class ModelTestSuite