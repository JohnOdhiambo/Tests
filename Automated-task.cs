using System;
using System.IO;

namespace AutomationExample
{
    class Program
    {
        static void Main(string[] args)
        {
            // Set the path of the folder to be monitored
            string folderPath = "C:\\Test\\";

            // Set the filter for the files to be monitored
            string filter = "*.txt";

            // Create a new FileSystemWatcher to monitor the folder
            FileSystemWatcher watcher = new FileSystemWatcher(folderPath, filter);

            // Set the event handlers for the watcher
            watcher.Created += OnFileCreated;
            watcher.Changed += OnFileChanged;
            watcher.Deleted += OnFileDeleted;

            // Start the watcher
            watcher.EnableRaisingEvents = true;

            // Wait for the user to press a key to exit the program
            Console.ReadKey();
        }

        static void OnFileCreated(object sender, FileSystemEventArgs e)
        {
            // Perform a task when a new file is created
            Console.WriteLine("A new file has been created: " + e.FullPath);
        }

        static void OnFileChanged(object sender, FileSystemEventArgs e)
        {
            // Perform a task when a file is modified
            Console.WriteLine("A file has been modified: " + e.FullPath);
        }

        static void OnFileDeleted(object sender, FileSystemEventArgs e)
        {
            // Perform a task when a file is deleted
            Console.WriteLine("A file has been deleted: " + e.FullPath);
        }
    }
}
