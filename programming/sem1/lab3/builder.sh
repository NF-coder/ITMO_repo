javac -d bin -classpath ./lib/*:./bin/:./ ./src/Main.java
cd bin; jar cfm ../Main.jar ../Manifest.mf src/; cd ..
