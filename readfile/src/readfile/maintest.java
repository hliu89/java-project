package readfile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class maintest {


    public static void main(String[] args) throws IOException {

    	List<employees> list=new ArrayList<employees>();
    	
    	
        FileInputStream fis
            = new FileInputStream(
                    "C:\\Users\\SAN2271\\Desktop\\xiexiaofei\\emp.txt");//Ҫ�����ļ�·��

        InputStreamReader isr 
            = new InputStreamReader(fis);//�ַ���
        
        BufferedReader br 
        = new BufferedReader(isr);    //����        
        String line = null;
        int i=0;
        while((line=br.readLine())!=null){//�ַ������ڿ�

        	employees a =new employees();
        	String[] s=line.split(" ");
            //System.out.println(line.toString());//һ��һ�е����
        		if(s.length>1) {
        	    a.setName(s[0]);
        		a.setID(s[1]);
        		//System.out.println(a.getID()+ " "+a.getName());
        		list.add(a);
        		}
        		
        }
        employees[] e=new employees[list.size()];
        for(int j=0;j<e.length;j++) {
        	e[j]=list.get(j);
        	//System.out.println(e[j].getName()+e[j].getID());
        }
        for(int q=0;q<e.length;q++) {
        	for(int k=q;k<e.length;k++) {
        		if(Integer.parseInt((e[q].getID()))>Integer.parseInt((e[k].getID()))) {
        			employees m=new employees();
        			m=e[q];
        			e[q]=e[k];
        			e[k]=m;
        		}
        	}
        }
        for(int l=0;l<e.length;l++) {
        	System.out.println(e[l].getName()+" "+e[l].getID());
        }
        
        br.close();//�ر��ļ�
    }

}
