javac -d bin -classpath ./bin/:./ ./src/Main.java
cd bin; jar cfm ../Main.jar ../MANIFEST.mf src/; cd ..