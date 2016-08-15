byte[] done = new byte[3];
String str = "done";  //randomly anything
done = str.getBytes();
for(int i =0; i < files.size(); i++){
    System.out.println(files.get(i).getName());
    FileInputStream fis = new FileInputStream(files.get(i));
    while((n =fis.read(buf)) != -1){
        dos.write(buf,0,n);
        System.out.println(n);
        dos.flush();
    }
 //should i close the dataoutputstream here and make a new one each time?                 
    dos.write(done,0,3);
    dos.flush();
}
        //or is this good?
        dos.close();