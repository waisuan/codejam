package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileFixIt {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		File file = new File(
				"C:\\Users\\waisuan\\Desktop\\codejam\\A-small-practice (4).in");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineNum = 0;
		int innerLineNum = 0;
		int caseNum = 1;
		int exists = -1;
		int newDir = -1;
		List<String> existingDirs = new ArrayList<String>();
		List<String> newDirs = new ArrayList<String>();

		while ((line = br.readLine()) != null) {

			if (lineNum > 0) {
				if (innerLineNum == 0) {
					String[] tokens = line.split(" ");

					exists = Integer.parseInt(tokens[0]);
					newDir = Integer.parseInt(tokens[1]);

					existingDirs.clear();
					newDirs.clear();
					// existingDirs = new String[exists];
					// newDirs = new String[newDir];

					innerLineNum++;
				} else {

					StringBuffer sBuffer = new StringBuffer("");

					for (int i = 0; i < exists; i++) {
						sBuffer.setLength(0);

						String[] tokens = line.split("\\/");

						for (int j = 1; j < tokens.length; j++) {
							sBuffer.append("/" + tokens[j]);

							if (!existingDirs.contains(sBuffer.toString())) {
								existingDirs.add(sBuffer.toString());
							}
						}

						line = br.readLine();
					}

					int matches = 0;
					for (int i = 0; i < newDir; i++) {
						sBuffer.setLength(0);

						String[] tokens = line.split("\\/");

						for (int j = 1; j < tokens.length; j++) {
							sBuffer.append("/" + tokens[j]);

							if (!existingDirs.contains(sBuffer.toString())) {
								// System.out.println(sBuffer.toString());
								existingDirs.add(sBuffer.toString());
								matches++;
							}
						}

						if (i + 1 != newDir)
							line = br.readLine();
					}

					System.out.println("Case #" + caseNum++ + ": " + matches);

					innerLineNum = 0;
				}
			}

			lineNum++;
		}

		br.close();
	}
}

// class Node {
// List<Node> listOfVertices = new ArrayList<Node>();
// String data = null;
//
// public Node(String data) {
// this.data = data;
// }
// }

// FIRST DRAFT
// public class FileFixIt {
//
// static int matches = 0;
//
// public static void main(String[] args) throws IOException {
// File file = new File(
// "C:\\Users\\waisuan\\Desktop\\codejam\\A-small-practice (4).in");
// BufferedReader br = new BufferedReader(new FileReader(file));
//
// String line;
// int lineNum = 0;
// int innerLineNum = 0;
// int caseNum = 1;
// int exists = -1;
// int newDir = -1;
// List<Node> listOfRootNodes = new ArrayList<Node>();
//
// while ((line = br.readLine()) != null) {
//
// matches = 0;
//
// if (lineNum > 0) {
// if (innerLineNum == 0) {
// String[] tokens = line.split(" ");
//
// exists = Integer.parseInt(tokens[0]);
// newDir = Integer.parseInt(tokens[1]);
//
// innerLineNum++;
//
// listOfRootNodes.clear();
// } else {
// for (int i = 0; i < exists; i++) {
// boolean found = false;
// String[] tokens = line.split("\\/");
//
// if (listOfRootNodes.isEmpty()) {
// Node rootNode = new Node(tokens[1]);
// matches++;
//
// Node currNode = rootNode;
// for (int j = 1; j < tokens.length; j++) {
// Node newNode = new Node(tokens[j]);
// currNode.listOfVertices.add(newNode);
// currNode = newNode;
// matches++;
// }
//
// listOfRootNodes.add(rootNode);
//
// found = true;
// } else {
// for (Node node : listOfRootNodes) {
// if (tokens[1].equals(node.data)) {
// // traverse
// if (!node.listOfVertices.isEmpty()) {
// for (int l = 0; l < node.listOfVertices
// .size(); l++) {
// if (1 != tokens.length) {
// if (node.listOfVertices.get(l)
// .equals(tokens[1])) {
// matches = findMatch(node,
// node.listOfVertices
// .get(l),
// tokens, 1, matches);
// found = true;
// break;
// }
// } else {
// found = true;
// break;
// }
//
// }
//
// if (!found) {
// for (int j = 1; j < tokens.length; j++) {
// Node newNode = new Node(
// tokens[j]);
// node.listOfVertices
// .add(newNode);
// node = newNode;
// matches++;
// }
// }
// } else {
// Node currNode = node;
// for (int j = 1; j < tokens.length; j++) {
// Node newNode = new Node(tokens[j]);
// currNode.listOfVertices
// .add(newNode);
// currNode = newNode;
// matches++;
// }
// }
//
// found = true;
// break;
// }
// }
//
// if (!found) {
// // add new
// Node rootNode = new Node(tokens[1]);
// matches++;
//
// Node currNode = rootNode;
// for (int j = 1; j < tokens.length; j++) {
// Node newNode = new Node(tokens[j]);
// currNode.listOfVertices.add(newNode);
// currNode = newNode;
// matches++;
// }
//
// listOfRootNodes.add(rootNode);
// }
// }
//
// line = br.readLine();
// }
//
// matches = 0;
//
// for (int i = 0; i < newDir; i++) {
// boolean found = false;
// String[] tokens = line.split("\\/");
//
// if (listOfRootNodes.isEmpty()) {
// Node rootNode = new Node(tokens[1]);
// matches++;
//
// Node currNode = rootNode;
// for (int j = 2; j < tokens.length; j++) {
// Node newNode = new Node(tokens[j]);
// currNode.listOfVertices.add(newNode);
// currNode = newNode;
// matches++;
// }
//
// listOfRootNodes.add(rootNode);
//
// found = true;
// } else {
// for (Node node : listOfRootNodes) {
// if (tokens[1].equals(node.data)) {
// // traverse
// if (!node.listOfVertices.isEmpty()) {
// for (int l = 0; l < node.listOfVertices
// .size(); l++) {
// if (2 != tokens.length) {
// if (node.listOfVertices.get(l).data
// .equals(tokens[2])) {
// matches = findMatch(node,
// node.listOfVertices
// .get(l),
// tokens, 2, matches);
// found = true;
// break;
// }
// } else if (2 == tokens.length) {
// found = true;
// break;
// }
//
// }
//
// if (!found) {
// for (int j = 2; j < tokens.length; j++) {
// Node newNode = new Node(
// tokens[j]);
// node.listOfVertices
// .add(newNode);
// node = newNode;
// matches++;
// }
// }
// } else {
// Node currNode = node;
// for (int j = 2; j < tokens.length; j++) {
// Node newNode = new Node(tokens[j]);
// currNode.listOfVertices
// .add(newNode);
// currNode = newNode;
// matches++;
// }
// }
//
// found = true;
// break;
// }
// }
//
// if (!found) {
// // add new
// Node rootNode = new Node(tokens[1]);
// matches++;
//
// Node currNode = rootNode;
// for (int j = 2; j < tokens.length; j++) {
// Node newNode = new Node(tokens[j]);
// currNode.listOfVertices.add(newNode);
// currNode = newNode;
// matches++;
// }
//
// listOfRootNodes.add(rootNode);
// }
// }
//
// if (i + 1 != newDir)
// line = br.readLine();
// }
//
// System.out.println("Case #" + caseNum++ + ": " + matches);
//
// innerLineNum = 0;
// }
// }
//
// lineNum++;
// }
//
// br.close();
// }
//
// private static int findMatch(Node parentNode, Node currNode,
// String[] tokens, int counter, int tempMatches) {
// if (tokens[counter].equals(currNode.data)) {
//
// List<Node> listOfVertices = currNode.listOfVertices;
//
// if (!listOfVertices.isEmpty()) {
// boolean found = false;
// for (int i = 0; i < listOfVertices.size(); i++) {
// if (counter + 1 != tokens.length) {
//
// if (listOfVertices.get(i).data
// .equals(tokens[counter + 1])) {
// tempMatches = findMatch(currNode,
// listOfVertices.get(i), tokens, counter + 1,
// tempMatches);
// found = true;
// break;
// }
// } else if (counter + 1 == tokens.length) {
// found = true;
// break;
// }
// }
//
// if (!found) {
// Node node = currNode;
// for (int j = counter + 1; j < tokens.length; j++) {
// Node newNode = new Node(tokens[j]);
// node.listOfVertices.add(newNode);
// node = newNode;
// matches++;
// tempMatches++;
// }
// }
// } else if (counter + 1 != tokens.length) {
// Node node = parentNode;
// for (int j = counter + 1; j < tokens.length; j++) {
// Node newNode = new Node(tokens[j]);
// node.listOfVertices.add(newNode);
// node = newNode;
// matches++;
// tempMatches++;
// }
// }
// } else {
// Node node = parentNode;
// for (int j = counter; j < tokens.length; j++) {
// Node newNode = new Node(tokens[j]);
// node.listOfVertices.add(newNode);
// node = newNode;
// matches++;
// tempMatches++;
// }
// }
//
// return tempMatches;
// }
// }
