class AppProcessBuilder {
    static void main(String[] args) {
        def processBuilder = new ProcessBuilder()
        processBuilder.command("/bin/bash",
                "-c",
                "/home/rizki/NetBeansProjects/shell-file/sftp.sh argument-1 argument-2 argument-3 argument-4"
        )

        try {
            def process = processBuilder.start()
            def stringBuilderOutput = new StringBuilder()
            def bufferedReaderBufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))

            def line
            while ((line = bufferedReaderBufferedReader.readLine()) != null) {
                stringBuilderOutput.append(line + "\n")
            }

            def exitValue = process.waitFor()
            if (exitValue == 0) {
                println("Success")
                if (stringBuilderOutput.length() != 0) {
                    println(stringBuilderOutput)
                }
            } else {
                println(exitValue)
                println("Error")
            }

        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
