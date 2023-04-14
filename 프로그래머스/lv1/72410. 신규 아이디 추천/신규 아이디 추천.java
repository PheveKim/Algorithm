class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "0123456789";
        String minus = "-_.";
        
        String last = "";
        Loop1: for(int i=0; i<new_id.length(); i++){
            
            char c = new_id.charAt(i);
            boolean is_in = false;
            for(int j=0; j<alpha.length(); j++){
                if(c == ALPHA.charAt(j)){
                    last += alpha.charAt(j);
                    is_in = true;
                    break;
                }
                else if(c == alpha.charAt(j)){
                    last += c;
                    is_in = true;
                    break;
                }
            }
            if(is_in == false){
                
                for(int j=0; j<number.length(); j++){
                    if(c == number.charAt(j)){
                        last += c;
                        is_in = true;
                        break;
                    }
                }
                if(is_in == false){
                    for(int j=0; j<minus.length(); j++){
                        if(c == minus.charAt(j)){
                            last += c;
                            is_in = true;
                            break;
                        }
                    }
                }
                
            }
        }
        while(true){
            int before_len = last.length();
            last = last.replace("..", ".");
            int after_len = last.length();
            if(before_len == after_len) break;
        }
        if(last.charAt(0) == '.') last = last.substring(1,last.length());
        if(last.length() > 0){
           if(last.charAt(last.length()-1) == '.') last = last.substring(0,last.length()-1);
        }
        if(last.length() == 0){
            last = "a";
        }
        if(last.length() >= 16){
            last = last.substring(0,15);
            if(last.charAt(last.length()-1) == '.') last = last.substring(0,last.length()-1);
        }
        if(last.length() <= 2){
            char c = last.charAt(last.length()-1);
            while(true){
                last += c;
                if(last.length() >= 3) break;
            }
        }
        
        
        return last;
    }
}