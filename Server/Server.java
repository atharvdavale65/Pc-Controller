import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Server {
	
	private static ServerSocket server = null;
	private static Socket client = null;
	private static BufferedReader in = null;
	private static String line;
	private static boolean isConnected=true;
	private static Robot robot;
	private static final int SERVER_PORT = 8080;  
 
	public static void main(String[] args) {
		boolean leftpressed=false;
		boolean rightpressed=false;
		System.out.println("Server has started");
		try {
           
            InetAddress localhost = InetAddress.getLocalHost();
            
            
            System.out.println("Your current IP address is: " + localhost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
		
 
	    try{
	    	robot = new Robot();
			server = new ServerSocket(SERVER_PORT); 
			client = server.accept(); 
			System.out.println("Client is connected ");
			
			in = new BufferedReader(new InputStreamReader(client.getInputStream())); 

		}catch (IOException e) {
			System.out.println("Error in opening Socket");
			System.exit(-1);
		}catch (AWTException e) {
			System.out.println("Error in creating robot instance");
			System.exit(-1);
		}
			
		
	    while(isConnected){
	        try{
			line = in.readLine(); 
			System.out.println(line); 
			String temp = "";
			if(line.contains("Brightness")){
				temp = line;
			}
			
			
			if(temp.length() >0 && temp.substring(0,10).equals("Brightness")){
				int n = line.length();
				String intensity = line.substring(10,n);
				new BrightnessManager();
				BrightnessManager.setBrightness(Integer.parseInt(intensity));

			}
			
			
			if(line.equalsIgnoreCase("next")){
				
				robot.keyPress(KeyEvent.VK_N);
				robot.keyRelease(KeyEvent.VK_N);
			}
			
			else if(line.equalsIgnoreCase("previous")){
				
				robot.keyPress(KeyEvent.VK_P);
				robot.keyRelease(KeyEvent.VK_P);		        	
			}
			
			else if(line.equalsIgnoreCase("play")){
				
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_SPACE);
			}
			
			else if(line.contains(",")){
				float movex=Float.parseFloat(line.split(",")[0]);
				float movey=Float.parseFloat(line.split(",")[1]);
				Point point = MouseInfo.getPointerInfo().getLocation(); 
				float nowx=point.x;
				float nowy=point.y;
				robot.mouseMove((int)(nowx+movex),(int)(nowy+movey));
			}
			
			else if(line.contains("left_click")){
				
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}

			
			else if(line.contains("right_click")){
				
				robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
			}

			
			else if(line.equalsIgnoreCase("space")){
				
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_SPACE);
			}

			
			else if(line.equalsIgnoreCase("caps_lock")){
				
				robot.keyPress(KeyEvent.VK_CAPS_LOCK );
				robot.keyRelease(KeyEvent.VK_CAPS_LOCK );
			}

			
			else if(line.equalsIgnoreCase("delete")){
				
				robot.keyPress(KeyEvent.VK_DELETE  );
				robot.keyRelease(KeyEvent.VK_DELETE  );
			}

			
			else if(line.equalsIgnoreCase("down_arrow_key")){
				
				robot.keyPress(KeyEvent.VK_DOWN  );
				robot.keyRelease(KeyEvent.VK_DOWN  );
			}

			
			else if(line.equalsIgnoreCase("enter")){
				
				robot.keyPress(KeyEvent.VK_ENTER   );
				robot.keyRelease(KeyEvent.VK_ENTER   );
			}

			
			else if(line.equalsIgnoreCase("esc")){
				
				robot.keyPress(KeyEvent.VK_ESCAPE    );
				robot.keyRelease(KeyEvent.VK_ESCAPE    );
			}

			
			else if(line.equalsIgnoreCase("f_1")){
				
				robot.keyPress(KeyEvent.VK_F1    );
				robot.keyRelease(KeyEvent.VK_F1    );
			}

			
			else if(line.equalsIgnoreCase("f_2")){
				
				robot.keyPress(KeyEvent.VK_F2    );
				robot.keyRelease(KeyEvent.VK_F2    );
			}

			
			else if(line.equalsIgnoreCase("f_3")){
				
				robot.keyPress(KeyEvent.VK_F3    );
				robot.keyRelease(KeyEvent.VK_F3    );
			}

			
			else if(line.equalsIgnoreCase("f_4")){
				
				robot.keyPress(KeyEvent.VK_F4   );
				robot.keyRelease(KeyEvent.VK_F4    );
			}

			
			else if(line.equalsIgnoreCase("f_5")){
				
				robot.keyPress(KeyEvent.VK_F5    );
				robot.keyRelease(KeyEvent.VK_F5    );
			}

			
			else if(line.equalsIgnoreCase("f_6")){
				
				robot.keyPress(KeyEvent.VK_F6    );
				robot.keyRelease(KeyEvent.VK_F6    );
			}

			
			else if(line.equalsIgnoreCase("f_7")){
				
				robot.keyPress(KeyEvent.VK_F7    );
				robot.keyRelease(KeyEvent.VK_F7    );
			}

			
			else if(line.equalsIgnoreCase("f_8")){
				
				robot.keyPress(KeyEvent.VK_F8    );
				robot.keyRelease(KeyEvent.VK_F8    );
			}

			
			else if(line.equalsIgnoreCase("f_9")){
				
				robot.keyPress(KeyEvent.VK_F9    );
				robot.keyRelease(KeyEvent.VK_F9    );
			}

			
			else if(line.equalsIgnoreCase("f_10")){
				
				robot.keyPress(KeyEvent.VK_F10    );
				robot.keyRelease(KeyEvent.VK_F10    );
			}

			
			else if(line.equalsIgnoreCase("f_11")){
				
				robot.keyPress(KeyEvent.VK_F11    );
				robot.keyRelease(KeyEvent.VK_F11    );
			}

			
			else if(line.equalsIgnoreCase("f_12")){
				
				robot.keyPress(KeyEvent.VK_F12    );
				robot.keyRelease(KeyEvent.VK_F12    );
			}

			
			else if(line.equalsIgnoreCase("insert")){
				
				robot.keyPress(KeyEvent.VK_INSERT     );
				robot.keyRelease(KeyEvent.VK_INSERT     );
			}

			
			else if(line.equalsIgnoreCase("up_arrow_key")){
				
				robot.keyPress(KeyEvent.VK_UP  );
				robot.keyRelease(KeyEvent.VK_UP  );
			}

			
			else if(line.equalsIgnoreCase("left_arrow_key")){
				
				robot.keyPress(KeyEvent.VK_LEFT  );
				robot.keyRelease(KeyEvent.VK_LEFT  );
			}

			
			else if(line.equalsIgnoreCase("right_arrow_key")){
				
				robot.keyPress(KeyEvent.VK_RIGHT  );
				robot.keyRelease(KeyEvent.VK_RIGHT  );
			}

			
			else if(line.equalsIgnoreCase("tab")){
				
				robot.keyPress(KeyEvent.VK_TAB  );
				robot.keyRelease(KeyEvent.VK_TAB  );
			}

			
			else if(line.equalsIgnoreCase("windows")){
				
				robot.keyPress(KeyEvent.VK_WINDOWS  );
				robot.keyRelease(KeyEvent.VK_WINDOWS  );
			}

			
			else if(line.equalsIgnoreCase("subtract")){
				
				robot.keyPress(KeyEvent.VK_SUBTRACT   );
				robot.keyRelease(KeyEvent.VK_SUBTRACT   );
			}

			
			else if(line.equalsIgnoreCase("plus")){
				
				 robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			       
			}

			
			else if(line.equalsIgnoreCase("alt")){
				
				robot.keyPress(KeyEvent.VK_ALT    );
				robot.keyRelease(KeyEvent.VK_ALT    );
			}

			
			else if(line.equalsIgnoreCase("home")){
				
				robot.keyPress(KeyEvent.VK_HOME     );
				robot.keyRelease(KeyEvent.VK_HOME     );
			}

			
			else if(line.equalsIgnoreCase("power_off")){
				
				Runtime runtime = Runtime.getRuntime();
				Process proc = runtime.exec("shutdown -s -t ");
				

			}

			
			else if(line.equalsIgnoreCase("lock_screen")){
				
				Runtime runtime = Runtime.getRuntime();
				try {
				    Process pr = runtime.exec("C:/WINDOWS/System32/rundll32.exe user32.dll,LockWorkStation");
				} catch (IOException e) {
				    e.printStackTrace();
				}
				

			}

			
			else if(line.equalsIgnoreCase("sleep_pc")){
				
				Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");

			}

			
			else if(line.equalsIgnoreCase("restart")){
				
				Runtime runtime = Runtime.getRuntime();
				Process proc = runtime.exec("shutdown -r");

			}


			
			else if(line.equalsIgnoreCase("exit")){
				isConnected=false;
				
				server.close();
				client.close();
			}

			else {
				
				switch (line) {
			        case "a":
			        robot.keyPress(KeyEvent.VK_A    );
					robot.keyRelease(KeyEvent.VK_A    );
			        break;
			        case "b":
			        robot.keyPress(KeyEvent.VK_B    );
					robot.keyRelease(KeyEvent.VK_B    );
			        break;
			        case "c":
			        robot.keyPress(KeyEvent.VK_C    );
					robot.keyRelease(KeyEvent.VK_C    );
			        break;
			        case "d":
			        robot.keyPress(KeyEvent.VK_D    );
					robot.keyRelease(KeyEvent.VK_D    );
			        break;
			        case "e": 
			        robot.keyPress(KeyEvent.VK_E);
			        robot.keyRelease(KeyEvent.VK_E); 
			        break;
			        case "f": 
			        robot.keyPress(KeyEvent.VK_F);
			        robot.keyRelease(KeyEvent.VK_F); 
			        break;
			        case "g": 
			        robot.keyPress(KeyEvent.VK_G);
			        robot.keyRelease(KeyEvent.VK_G); 
			        break;
			        case "h": 
			        robot.keyPress(KeyEvent.VK_H);
			        robot.keyRelease(KeyEvent.VK_H); 
			        break;
			        case "i": 
			        robot.keyPress(KeyEvent.VK_I);
			        robot.keyRelease(KeyEvent.VK_I); 
			        break;
			        case "j": 
			        robot.keyPress(KeyEvent.VK_J);
			        robot.keyRelease(KeyEvent.VK_J); 
			        break;
			        case "k": 
			        robot.keyPress(KeyEvent.VK_K);
			        robot.keyRelease(KeyEvent.VK_K); 
			        break;
			        case "l": 
			        robot.keyPress(KeyEvent.VK_L);
			        robot.keyRelease(KeyEvent.VK_L); 
			        break;
			        case "m": 
			        robot.keyPress(KeyEvent.VK_M);
			        robot.keyRelease(KeyEvent.VK_M); 
			        break;
			        case "n": 
			        robot.keyPress(KeyEvent.VK_N);
			        robot.keyRelease(KeyEvent.VK_N); 
			        break;
			        case "o": 
			        robot.keyPress(KeyEvent.VK_O);
			        robot.keyRelease(KeyEvent.VK_O); 
			        break;
			        case "p": 
			        robot.keyPress(KeyEvent.VK_P);
			        robot.keyRelease(KeyEvent.VK_P); 
			        break;
			        case "q": 
			        robot.keyPress(KeyEvent.VK_Q);
			        robot.keyRelease(KeyEvent.VK_Q); 
			        break;
			        case "r": 
			        robot.keyPress(KeyEvent.VK_R);
			        robot.keyRelease(KeyEvent.VK_R); 
			        break;
			        case "s": 
			        robot.keyPress(KeyEvent.VK_S);
			        robot.keyRelease(KeyEvent.VK_S); 
			        break;
			        case "t": 
			        robot.keyPress(KeyEvent.VK_T);
			        robot.keyRelease(KeyEvent.VK_T); 
			        break;
			        case "u": 
			        robot.keyPress(KeyEvent.VK_U);
			        robot.keyRelease(KeyEvent.VK_U); 
			        break;
			        case "v": 
			        robot.keyPress(KeyEvent.VK_V);
			        robot.keyRelease(KeyEvent.VK_V); 
			        break;
			        case "w": 
			        robot.keyPress(KeyEvent.VK_W);
			        robot.keyRelease(KeyEvent.VK_W); 
			        break;
			        case "x": 
			        robot.keyPress(KeyEvent.VK_X);
			        robot.keyRelease(KeyEvent.VK_X); 
			        break;
			        case "y": 
			        robot.keyPress(KeyEvent.VK_Y);
			        robot.keyRelease(KeyEvent.VK_Y); 
			        break;
			        case "z": 
			        robot.keyPress(KeyEvent.VK_Z);
			        robot.keyRelease(KeyEvent.VK_Z); 
			        break;

			        case "A":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_A    );
					robot.keyRelease(KeyEvent.VK_A    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "B":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_B    );
					robot.keyRelease(KeyEvent.VK_B    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "C":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_C    );
					robot.keyRelease(KeyEvent.VK_C    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "D":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_D    );
					robot.keyRelease(KeyEvent.VK_D    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "E":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_E   );
					robot.keyRelease(KeyEvent.VK_E    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "F":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_F    );
					robot.keyRelease(KeyEvent.VK_F    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "G":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_G    );
					robot.keyRelease(KeyEvent.VK_G    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "H":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_H    );
					robot.keyRelease(KeyEvent.VK_H    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "I":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_I    );
					robot.keyRelease(KeyEvent.VK_I    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "J":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_J    );
					robot.keyRelease(KeyEvent.VK_J    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "K":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_K    );
					robot.keyRelease(KeyEvent.VK_K    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "L":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_L    );
					robot.keyRelease(KeyEvent.VK_L    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			       case "M":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_M    );
					robot.keyRelease(KeyEvent.VK_M    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "N":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_N    );
					robot.keyRelease(KeyEvent.VK_N    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "O":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_O    );
					robot.keyRelease(KeyEvent.VK_O    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "P":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_P    );
					robot.keyRelease(KeyEvent.VK_P    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "Q":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_Q    );
					robot.keyRelease(KeyEvent.VK_Q    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "R":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_R    );
					robot.keyRelease(KeyEvent.VK_R    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "S":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_S    );
					robot.keyRelease(KeyEvent.VK_S    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "T":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_T    );
					robot.keyRelease(KeyEvent.VK_T    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "U":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_U    );
					robot.keyRelease(KeyEvent.VK_U    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "V":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_V    );
					robot.keyRelease(KeyEvent.VK_V    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "W":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_W    );
					robot.keyRelease(KeyEvent.VK_W    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "X":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_X    );
					robot.keyRelease(KeyEvent.VK_X    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "Y":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_Y    );
					robot.keyRelease(KeyEvent.VK_Y    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "Z":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_Z    );
					robot.keyRelease(KeyEvent.VK_Z    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			
			        case "`": 
			        robot.keyPress(KeyEvent.VK_BACK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
			        break;

			        case "0": 
			        robot.keyPress(KeyEvent.VK_0);
			        robot.keyRelease(KeyEvent.VK_0);
			        break;
			        case "1": 
			        robot.keyPress(KeyEvent.VK_1);
			        robot.keyRelease(KeyEvent.VK_1);
			        break;
			        case "2": 
			        robot.keyPress(KeyEvent.VK_2);
			        robot.keyRelease(KeyEvent.VK_2);
			        break;
			        case "3": 
			        robot.keyPress(KeyEvent.VK_3);
			        robot.keyRelease(KeyEvent.VK_3);
			        break;
			        case "4": 
			        robot.keyPress(KeyEvent.VK_4);
			        robot.keyRelease(KeyEvent.VK_4);
			        break;
			        case "5": 
			        robot.keyPress(KeyEvent.VK_5);
			        robot.keyRelease(KeyEvent.VK_5);
			        break;
			        case "6": 
			        robot.keyPress(KeyEvent.VK_6);
			        robot.keyRelease(KeyEvent.VK_6);
			        break;
			        case "7": 
			        robot.keyPress(KeyEvent.VK_7);
			        robot.keyRelease(KeyEvent.VK_7);
			        break;
			        case "8": 
			        robot.keyPress(KeyEvent.VK_8);
			        robot.keyRelease(KeyEvent.VK_8);
			        break;
			        case "9": 
			        robot.keyPress(KeyEvent.VK_9);
			        robot.keyRelease(KeyEvent.VK_9);
			        break;

			         case "-": 
			        robot.keyPress(KeyEvent.VK_MINUS);
			        robot.keyRelease(KeyEvent.VK_MINUS);
			        break;

			         case "+": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			         case "=":
			        robot.keyPress(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_EQUALS);
			        break;

			         case "~": 
			        robot.keyPress(KeyEvent.VK_BACK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
			        break;
			         case "!": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_1);
			        robot.keyRelease(KeyEvent.VK_1);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "@": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_2);
			        robot.keyRelease(KeyEvent.VK_2);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "#": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_3);
			        robot.keyRelease(KeyEvent.VK_3);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "$": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_4);
			        robot.keyRelease(KeyEvent.VK_4);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "%": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_5);
			        robot.keyRelease(KeyEvent.VK_5);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "^":
			         robot.keyPress(KeyEvent.VK_SHIFT); 
			        robot.keyPress(KeyEvent.VK_6);
			        robot.keyRelease(KeyEvent.VK_6);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "&":
			         robot.keyPress(KeyEvent.VK_SHIFT); 
			        robot.keyPress(KeyEvent.VK_7);
			        robot.keyRelease(KeyEvent.VK_7);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "*": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_8);
			        robot.keyRelease(KeyEvent.VK_8);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "(": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_9);
			        robot.keyRelease(KeyEvent.VK_9);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case ")": 
			         
			       robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_0);
			        robot.keyRelease(KeyEvent.VK_0);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        
			        break;
			         case "_":
			         robot.keyPress(KeyEvent.VK_SHIFT); 
			        robot.keyPress(KeyEvent.VK_MINUS);
			        robot.keyRelease(KeyEvent.VK_MINUS);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "\t": 
			        robot.keyPress(KeyEvent.VK_TAB);
			        robot.keyRelease(KeyEvent.VK_TAB);
			        break;
			         case "\n": 
			        robot.keyPress(KeyEvent.VK_ENTER);
			        robot.keyRelease(KeyEvent.VK_ENTER);
			        break;
			         case "[": 
			        robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
			        robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
			        break;
			         case "]": 
			        robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
			        break;
			        case "\\": 
			        robot.keyPress(KeyEvent.VK_BACK_SLASH);
			        robot.keyRelease(KeyEvent.VK_BACK_SLASH);
			        break;
			        case "{": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
			        robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "}": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "|": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_BACK_SLASH);
			        robot.keyRelease(KeyEvent.VK_BACK_SLASH);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case ";": 
			        robot.keyPress(KeyEvent.VK_SEMICOLON);
			        robot.keyRelease(KeyEvent.VK_SEMICOLON);
			        break;
			        case ":": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "\'": 
			        robot.keyPress(KeyEvent.VK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_QUOTE);
			        break;

			        case "\"": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			        case "<": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_COMMA);
			        robot.keyRelease(KeyEvent.VK_COMMA);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			        case ",": 
			        robot.keyPress(KeyEvent.VK_COMMA);
			        robot.keyRelease(KeyEvent.VK_COMMA);
			        break;
			        case ".": 
			        robot.keyPress(KeyEvent.VK_PERIOD);
			        robot.keyRelease(KeyEvent.VK_PERIOD);
			        break;
			        case ">": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_PERIOD);
			        robot.keyRelease(KeyEvent.VK_PERIOD);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			        case "/": 
			        robot.keyPress(KeyEvent.VK_SLASH);
			        robot.keyRelease(KeyEvent.VK_SLASH);
			        break;

			        case "?": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_SLASH);
			        robot.keyRelease(KeyEvent.VK_SLASH);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			        case " ": 
			        robot.keyPress(KeyEvent.VK_SPACE);
			        robot.keyRelease(KeyEvent.VK_SPACE);
			        break;

			        case "\b": 
			        robot.keyPress(KeyEvent.VK_BACK_SPACE);
			        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
			        break;

			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        default:
            
        }
			}
	        } catch (IOException e) {
				System.out.println("Read failed");
				System.exit(-1);
	        }
      	}
	}












	

}
