package challenge;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if(texto == null){
            throw new NullPointerException();
        }else if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            texto = toLowerCase(texto);
            StringBuilder phaseCripto = new StringBuilder();
            int temp = 0;

            for(int x = 0; x < texto.length(); x++){
                if(texto.charAt(x) >= 97 && texto.charAt(x) <= 122){
                    temp = (int)texto.charAt(x) + 3;
                    if(temp > 122){
                        temp = (96 + temp % 122);
                    }
                }else{
                    temp = (int)texto.charAt(x);
                }
                phaseCripto.append((char)temp);
            }
            return phaseCripto.toString();
        }

    }

    @Override
    public String descriptografar(String texto) {
        if(texto == null){
            throw new NullPointerException();
        }else if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }else {
            texto = toLowerCase(texto);
            StringBuilder phaseCripto = new StringBuilder();
            int temp = 0;

            for (int x = 0; x < texto.length(); x++) {
                if (texto.charAt(x) >= 97 && texto.charAt(x) <= 122) {
                    temp = (int) texto.charAt(x) - 3;
                    if (temp < 97) {
                        temp = (123 - 97 % temp);
                    }
                } else {
                    temp = (int) texto.charAt(x);
                }
                phaseCripto.append((char) temp);
            }
            return phaseCripto.toString();
        }
    }
}
