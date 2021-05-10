import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public final class DirectoryProcessor {

    public static List<File> getDirectoryList(String directory) throws IOException {
        List<File> files = Files.list(Paths.get(directory))
            .filter(Files::exists)
            .map(Path::getFileName)
            .map(Path::toFile)
            .collect(Collectors.toList());

        return files;
    }

}
