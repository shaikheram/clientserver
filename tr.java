public void receive(){


    try {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//read the number of files from the client
        int number = dis.readInt();
        ArrayList<File>files = new ArrayList<File>(number);
        System.out.println("Number of Files to be received: " +number);
        //read file names, add files to arraylist
        for(int i = 0; i< number;i++){
            File file = new File(dis.readUTF());
            files.add(file);
        }
        int n = 0;
        byte[]buf = new byte[4092];

        //outer loop, executes one for each file
        for(int i = 0; i < files.size();i++){

            System.out.println("Receiving file: " + files.get(i).getName());
            //create a new fileoutputstream for each new file
            FileOutputStream fos = new FileOutputStream("C:\\users\\tom5\\desktop\\salestools\\" +files.get(i).getName());
            //read file
            while((n = dis.read(buf)) != -1){
                fos.write(buf,0,n);
                fos.flush();
            }
            fos.close();
        }

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();

    }


}