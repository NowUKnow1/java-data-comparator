run-dist:
		/build/install/app/bin/app
report:
	./gradlew jacocoTestReport
.PHONY: build