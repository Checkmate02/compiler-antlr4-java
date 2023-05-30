package compiler.generating;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Stack;

public class Calculating implements MochalovICode {
	public final int zero = 0;
	Stack<Integer> data;
	Stack<Method> methods;
	int next = 0;
	File classFile;

	public Calculating(String name) {
		data = new Stack<>();
		methods = new Stack<>();
		classFile = readFromFile(name);
	}

	public void dataZeroPush() {
		data.push(0);
	}

	public void dataOnePush() {
		data.push(1);
	}

	public void executable() {
		int number;
		int code = zero;
		Method method = classFile.getMainMethod();
		while (code != STOP)
		{
			Regulations regulations = method.getInstruction(next);
			code = regulations.getCode();
			Object argument = regulations.getArgument();
			switch (code)
			{
				case SUB:
					Integer n1 = data.pop();
					Integer n2 = data.pop();
					data.push(n2 - n1);
					break;
				case ILT:
					n1 = data.pop();
					n2 = data.pop();
					if (n2 < n1) dataOnePush();
					else dataZeroPush();
					break;
				case NO:
					if (data.pop() == 0) dataOnePush();
					else dataZeroPush();
					break;
				case AND:
					if (data.pop() * data.pop() == 0)
						dataZeroPush();
					else dataOnePush();
					break;
				case OR:
					if (data.pop() + data.pop() == 0)
						dataZeroPush();
					else dataOnePush();
					break;
				case GOTO:
					number = Integer.parseInt(argument.toString());
					next = number - 1;
					break;
				case CONST:
					data.push(Integer.parseInt(argument.toString()));
					break;
				case STORE:
					number = Integer.parseInt(argument.toString());
					method.getVarList().set(number, data.pop());
					break;
				case LOAD:
					number = Integer.parseInt(argument.toString());
					data.push(method.getVarList().get(number));
					break;
				case ADD:
					data.push(data.pop() + data.pop());
					break;
				case MULTI:
					data.push(data.pop() * data.pop());
					break;
				case IF_FALSE:
					number = Integer.parseInt(argument.toString());
					if (data.pop() == 0)
						next = number - 1;
					break;
				case INVOKE:
					method.setPC(next);
					methods.push(method);
					method = classFile.getMethods().get(argument.toString());
					next = -1;
					break;
				case RETURN:
					method = methods.pop();
					next = method.getPC();
					break;
				case PRINT:
					System.out.println(data.pop());
					break;
			}
			next++;
		}
	}

	public File readFromFile(String name) {
		ObjectInputStream In;
		File file = null;
		try {
			In = new ObjectInputStream(new BufferedInputStream(new FileInputStream(name)));
			file = (File) In.readObject();
			In.close();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Неверный путь к файлу!");
		}
		return file;
	}
}
