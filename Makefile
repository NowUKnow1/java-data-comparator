run-dist:
		/build/install/app/bin/app
coverageCommand:
		make report
report:
	./gradlew jacocoTestReport
.PHONY: build