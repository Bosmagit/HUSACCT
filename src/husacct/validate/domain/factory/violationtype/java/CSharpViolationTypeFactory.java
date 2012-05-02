package husacct.validate.domain.factory.violationtype.java;

import husacct.validate.domain.validation.ViolationType;
import husacct.validate.domain.validation.violationtype.csharp.CSharpDependencyRecognition;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CSharpViolationTypeFactory extends AbstractViolationType {
	private EnumSet<CSharpDependencyRecognition> defaultDependencies = EnumSet.allOf(CSharpDependencyRecognition.class);		
	private static final String csharpViolationTypesRootPackagename = "csharp";	

	public CSharpViolationTypeFactory(){
		super();
		this.allViolationKeys = generator.getAllViolationTypeKeys(csharpViolationTypesRootPackagename);
	}

	@Override
	public List<ViolationType> createViolationTypesByRule(String key) {
		if(isCategoryLegalityOfDependency(key)){
			return generateViolationTypes(defaultDependencies);
		}
		else{
			return Collections.emptyList();
		}
	}
	
	@Override
	public HashMap<String, List<ViolationType>> getAllViolationTypes(){
		Map<String, String> violationTypeKeysAndCategories = generator.getAllViolationTypesWithCategory(csharpViolationTypesRootPackagename);
		return getAllViolationTypes(violationTypeKeysAndCategories);
	}
}