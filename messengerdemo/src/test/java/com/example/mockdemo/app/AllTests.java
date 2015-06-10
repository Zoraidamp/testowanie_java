package com.example.mockdemo.app;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	DynamicProxyTest.class, 
	EasyMockTest.class, 
	MockitoTest.class,
	SimpleTest.class })
public class AllTests {}
