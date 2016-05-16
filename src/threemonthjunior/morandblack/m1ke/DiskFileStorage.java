/**
 * 
 */
package threemonthjunior.morandblack.m1ke;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements file storage with the regular directory on disk.
 * 
 * The hashing algorithm is to generate a hex string where 
 * first 64 bits (16 chars) are file size 
 * and the next 160 bits (40 chars) - SHA-1 hash
 * 
 * @author 
 *
 */
class DiskFileStorage implements FileStorage {
    
    private Path workingDirectory;
    
    /**
     * Gets a list of all files in the storage which have given hash.
     * 
     * @param hash
     *        hash of a file to look for
     *        
     * @return a list of absolute paths to the files found 
     *         or an empty list if the files weren't found 
     */
    private List<Path> filesWithHash(String hash) {
        // TODO return a list of all the files with such hash

        ArrayList<Path> result = new ArrayList<>();
        Path p = workingDirectory.resolve(hash);
        DirectoryStream<Path> stream;
        try {
            stream = Files.newDirectoryStream(p);

            for (Path entry : stream){
                result.add(entry);
            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * 1) Create a Path variable representing workingDirectory
         * 2) Check if a subdirectory with name.equals(hash) exists
         * 3) If exists, return a list with Paths 
         *    to gzip files that are inside that directory
         * 4) If doesn't exist return an empty List (but not a null)
         * 
         * see repo_structure.txt for a better understanding
         * 
         * */
        
        return result;
    }
    
    /**
     * Creates a new storage instance with given 
     * working directory absolute path.
     */
    public DiskFileStorage(Path workingDirectory) {
        // TODO validate input
        if(!Files.exists(workingDirectory) && !Files.isDirectory(workingDirectory)) throw new IllegalArgumentException("Working directory " + workingDirectory + " is not valid!");

        this.workingDirectory = workingDirectory;

    }

    /* (non-Javadoc)
     * @see threemonthjunior.morandblack.m1ke.FileStorage#storeFileAndGetID(java.io.InputStream)
     */
    @Override
    public FileIdentifier storeFileAndGetID(InputStream data) {
        // TODO Auto-generated method stub
        FileIdentifier result = new FileIdentifier();

        try {
            result.setHash(String.format("%016d", Files.size(workingDirectory)) + FileUtils.calculateHash(workingDirectory));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //result.setPosition();



        return result;
    }


    /* (non-Javadoc)
     * @see threemonthjunior.morandblack.m1ke.FileStorage#getFileById(threemonthjunior.morandblack.m1ke.FileIdentifier)
     */
    @Override
    public InputStream getFileById(FileIdentifier id) {
        // TODO Auto-generated method stub
        return null;
    }

}
