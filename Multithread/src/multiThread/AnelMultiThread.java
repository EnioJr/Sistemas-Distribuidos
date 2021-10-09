package multiThread;

class ThreadRunnable implements Runnable {
	private Thread thread;
	private StringBuffer threadName;
	private int positionMesage;

	// Criando Thread com o recebimento da Mensagem
	ThreadRunnable(StringBuffer name, int positionCharacterMensage) {
		threadName = name;
		positionMesage = positionCharacterMensage;
	}

//	Thread sendo executada(Rodando)
	public void run() {
//		System.out.println("Running " + threadName);
		try {

			threadName.setCharAt(positionMesage,
					(String.valueOf(threadName.charAt(positionMesage)).toUpperCase().charAt(0)));
			System.out.println(thread.getName() + " : " + threadName);

			// thread sendo pausada por 1 segundo.
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
	}

//	Startando a Thread, ou seja inicializando a Thread, para ele começar a rodar
	public void start() {
//		System.out.println("Starting " + threadName);
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
}

public class AnelMultiThread {

	public static void main(String args[]) {
		int qtdThread = 30;
		StringBuffer msg = new StringBuffer(
				"Uma pequena mensagem que ira passar por um loop, onde ira transformar todas as letras");

		for (int i = 0; i <= qtdThread; i++) {
			ThreadRunnable R1 = new ThreadRunnable(msg, i);
			R1.start();
		}
	}

	public static void testMesage() {
		StringBuffer mensagem = new StringBuffer("qualquer coisa aki");
		StringBuffer resultado = TornarMaiuscula(mensagem);
		System.out.println(resultado);
	}

	public static StringBuffer TornarMaiuscula(StringBuffer palavra) {

		for (int i = 0; i < palavra.length(); i++) {
//			String t = String.valueOf(palavra.charAt(i)).toUpperCase();
			palavra.setCharAt(i, (String.valueOf(palavra.charAt(i)).toUpperCase().charAt(0)));
			System.out.println(palavra);
		}
		return (palavra);
	}

}
