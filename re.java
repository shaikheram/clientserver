for(int i = 0; i < files.size();i++){
    System.out.println("Receiving file: " + files.get(i).getName());
 //create a new fileoutputstream for each new file
fos = new FileOutputStream("C:\\users\\tom5\\desktop\\salestools\\" +files.get(i).getName());
//read file
while((n = dis.read(buf)) != -1 && n!=3 ){
        fos.write(buf,0,n);
        fos.flush();
        }
            fos.close();
        }