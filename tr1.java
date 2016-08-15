public void send(ArrayList<File>files){

    try {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println(files.size());
//write the number of files to the server
        dos.writeInt(files.size());
        dos.flush();

        //write file names 
        for(int i = 0 ; i < files.size();i++){
            dos.writeUTF(files.get(i).getName());
            dos.flush();
        }

        //buffer for file writing, to declare inside or outside loop?
        int n = 0;
        byte[]buf = new byte[4092];
        //outer loop, executes one for each file
        for(int i =0; i < files.size(); i++){

            System.out.println(files.get(i).getName());
            //create new fileinputstream for each file
            FileInputStream fis = new FileInputStream(files.get(i));

            //write file to dos
            while((n =fis.read(buf)) != -1){
                dos.write(buf,0,n);
                dos.flush();

            }
            //should i close the dataoutputstream here and make a new one each time?
        }
        //or is this good?
        dos.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


}