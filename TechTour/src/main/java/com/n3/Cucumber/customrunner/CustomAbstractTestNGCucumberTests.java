package com.n3.Cucumber.customrunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;


public class CustomAbstractTestNGCucumberTests {
	private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
        testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
    }


    @DataProvider
    public Iterator<Object[]> scenarios() {
    	ArrayList<Object[]> modifiedList = new ArrayList<>();
        if (testNGCucumberRunner == null) {
            //return new Object[0][0];
        	return modifiedList.iterator();
        }

        modifiedList = filterTheFeature(testNGCucumberRunner.provideScenarios());

        return modifiedList.iterator();
    }

    
    private ArrayList<Object[]> filterTheFeature(Object[][] data) {
    	String featureValue = System.getProperty("FeatureName");
    	
    	if(featureValue == null || featureValue.isEmpty()){
    		return getFeatureList(data);
    	}
    	
    	List<String> featureList = Arrays.asList(featureValue.split(","));
 		ArrayList<Object[]> modifiedList = new ArrayList<>();
		
		if(data != null){
			for (int i = 0; i < data.length; i++) {
				CucumberFeatureWrapper cucumberFeatureWrapper = (CucumberFeatureWrapper)data[i][1];
				if(featureList.contains(cucumberFeatureWrapper.toString().trim().replaceAll("\"", ""))){
					modifiedList.add(data[i]);

				}
			}
		}
		return modifiedList;
	}
    
    private ArrayList<Object[]> getFeatureList(Object[][] data) {
    	ArrayList<Object[]> modifiedList = new ArrayList<>();
    	if(data != null){
			for (int i = 0; i < data.length; i++) {
					modifiedList.add(data[i]);
			}
		}
    	return modifiedList;
	}
     
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }

}
