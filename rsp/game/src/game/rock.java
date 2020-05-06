package game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class rock extends JFrame implements ActionListener {
	
	JLabel lblCom, lblUser, lblVS, lblResult, lblScore;
	JButton btnmook, btnjji, btnbba;
	int win=0;
	int draw=0;
	int lose=0;
	
	
	ImageIcon Icon[] = {
			new ImageIcon("./img/mook.png"),
			new ImageIcon("./img/jji.png"),
			new ImageIcon("./img/bba.png")
	};
	
	ImageIcon smallIcon[] = {
			new ImageIcon("./img/small_mook.png"),
			new ImageIcon("./img/small_jji.png"),
			new ImageIcon("./img/small_bba.png")
	};
	
	public rock() {
		setBounds(100, 100, 800, 600);
		setTitle("°¡À§¹ÙÀ§º¸ °ÔÀÓ");
		setLayout(null);
		
		Container ct = getContentPane();
		ct.setBackground(Color.white);
		
		lblScore = new JLabel("0½Â0¹«0ÆÐ");
		lblScore.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
		lblScore.setBounds(300, 0, 500, 50);
		
		lblCom = new JLabel(new ImageIcon("./img/first.jpg"));
		lblCom.setBounds(50, 50, 300, 300);
		
		lblVS = new JLabel("VS");
		lblVS.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
		lblVS.setBounds(375, 50, 50, 300);
		
		lblUser = new JLabel(new ImageIcon(".img/first.jpg"));
		lblUser.setBounds(450, 50, 300, 300);
		
		lblResult = new JLabel();
		lblResult.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
		lblResult.setBounds(350, 180, 200, 300);
		
		btnmook = new JButton(smallIcon[0]);
		btnmook.setBounds(50, 400, 150, 150);
		btnjji = new JButton(smallIcon[1]);
		btnjji.setBounds(325, 400, 150,150);
		btnbba = new JButton(smallIcon[2]);
		btnbba.setBounds(600, 400, 150, 150);
		
		btnmook.addActionListener(this);
		btnjji.addActionListener(this);
		btnbba.addActionListener(this);
		
		ct.add(lblCom);
		ct.add(lblUser);
		ct.add(lblVS);
		ct.add(btnmook);
		ct.add(btnjji);
		ct.add(btnbba);
		ct.add(lblResult);
		ct.add(lblScore);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new rock();
	}
	
	public void chkResult(int user){
		int com = (int) ((Math.random()*1000)%3)+1;
		lblCom.setIcon(Icon[com-1]);
		if(com==user){
			draw++;
			lblResult.setText("ºñ°å´Ù!!");
		}else if((com==1 && user==3) || (com==2 && user==1) || (com==3 && user==2)){
			win++;
			lblResult.setText("ÀÌ°å´Ù!!");
		}else if((com==1 && user==2)||(com==2 && user==3)||com==3 && user==1){
			lose++;
			lblResult.setText("Á®¹ö·È¾î");
	}else{
		lblResult.setText("¸Ó³Ä??");
	}
		lblScore.setText(win+"½Â" + draw + "¹«" + lose + "ÆÐ");
}
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == btnmook){
			lblUser.setIcon(Icon[0]);
			chkResult(1);
		}else if(ob == btnjji){
			lblUser.setIcon(Icon[1]);
			chkResult(2);
		}else if(ob == btnbba){
			lblUser.setIcon(Icon[2]);
			chkResult(3);
		}
	}
}