package com.vince.sshxcute;

import net.neoremind.sshxcute.core.ConnBean;
import net.neoremind.sshxcute.core.SSHExec;
import net.neoremind.sshxcute.exception.TaskExecFailException;
import net.neoremind.sshxcute.task.impl.ExecCommand;

/**
 * 用JavaApi操作Linux命令
 */
public class SSHXcuteMain {
    public static void main(String[] args) throws TaskExecFailException {
        //实现echo "helloword"  >> /export/helloword.txt
        //核心类 SSHExec
        ConnBean conn = new ConnBean("192.168.52.120", "root", "123456");
        SSHExec ssh = SSHExec.getInstance(conn);
        ssh.connect();//连接linux 服务器
        ExecCommand execCommand = new ExecCommand("echo 'helloword' >>/export/helloword.txt");
        ssh.exec(execCommand);
        ssh.disconnect();



    }
}
