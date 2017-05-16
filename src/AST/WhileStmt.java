/*
Vinicius Yamamoto     RA 490105
Daniel Valim    RA  511315
*/
package AST;
import java.util.*;

public class WhileStmt{
	public WhileStmt(char tk, ArrayList<Stmt> st, Comparison com){
		this.tk = tk;
		this.st = st;
		this.com = com;
	}

	public void genC(PW pw){
		pw.out.print("while(");
		com.genC(pw);
		pw.out.print("){\n");
		for(int i=0; i<st.size();i++){
			st.get(i).genC(pw);
		}
		pw.out.print("\n}");
	}

	private char tk;
	private ArrayList<Stmt> st;
	private Comparison com;
}