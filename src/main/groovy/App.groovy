import org.apache.commons.exec.CommandLine
import org.apache.commons.exec.DefaultExecutor
import org.apache.commons.exec.ExecuteWatchdog
import org.apache.commons.exec.PumpStreamHandler

class App {
    static void main(String[] args) {
        def commandLine = new CommandLine("/home/rizki/NetBeansProjects/shell-file/sftp.sh")
        commandLine.addArgument("argument-1")
        commandLine.addArgument("argument-2")
        commandLine.addArgument("argument-3")
        commandLine.addArgument("argument-4")

        def byteArrayOutputStream = new ByteArrayOutputStream()
        def pumpStreamHandler = new PumpStreamHandler(byteArrayOutputStream)

        def executeWatchdog = new ExecuteWatchdog(60000)

        def executor = new DefaultExecutor()
        executor.setStreamHandler(pumpStreamHandler)
        executor.setWatchdog(executeWatchdog)
        executor.setExitValue(0)

        def exitValue = executor.execute(commandLine)
        println("result ${exitValue}")
        println(new String(byteArrayOutputStream.toByteArray()))
    }
}