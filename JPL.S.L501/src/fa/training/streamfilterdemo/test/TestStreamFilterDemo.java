package fa.training.streamfilterdemo.test;

import fa.training.streamfilterdemo.FilterMapByKeyExample;
import fa.training.streamfilterdemo.FilterMapByValueExample;
import fa.training.streamfilterdemo.PersonFilterExample;
import fa.training.streamfilterdemo.PersonFilterMapExample;
import fa.training.streamfilterdemo.PersonFilterMatchesExample;
import fa.training.streamfilterdemo.PersonFilterMultipleConditionExample;

public class TestStreamFilterDemo {
	public static void main(String[] args) {

		PersonFilterExample personFilter = new PersonFilterExample();
		PersonFilterMultipleConditionExample filterMultipleCondition = new PersonFilterMultipleConditionExample();
		PersonFilterMapExample filterMap = new PersonFilterMapExample();
		PersonFilterMatchesExample filterMatched = new PersonFilterMatchesExample();
		FilterMapByKeyExample filterMapByKey = new FilterMapByKeyExample();
		FilterMapByValueExample filterMapByValue = new FilterMapByValueExample();
		personFilter.showPerson();
		personFilter.showPersonWithStreamFilter();
		filterMultipleCondition.filterMultipleCondition();
		filterMap.filterAndMap();
		filterMatched.filterWithMatchPattern();
		filterMapByKey.filterMapByKey();
		filterMapByValue.filterMapByValues();
	}

}
