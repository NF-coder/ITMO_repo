javac -d bin -classpath . ./src/Main.java
cd bin; jar cfm ../Main.jar ../MANIFEST.mf src/; cd ..
