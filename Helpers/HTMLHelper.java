package Helpers;

/**
 * This class will help to create a String to build dynamic html
 */
public class HTMLHelper 
{
	private String htmlString;
	
	//Zero-Parameter Constructor
	public HTMLHelper()
	{
		htmlString = "";
	}
	
	//Creates an opening Form Tag
	public void openFormTag()
	{
		htmlString += "<form>";
	}
	
	//Creates a closing Form Tag
	public void closeFormTag()
	{
		htmlString += "</form>";
	}
	
	//Creates an opening Table Tag
	public void openTableTag()
	{
		htmlString += "<table>";
	}
	
	//Creates a closing Table Tag
	public void closeTableTag()
	{
		htmlString += "</table>";
	}
	
	//Creates an opening Table Row Tag
	public void openTableRowTag()
	{
		htmlString += "<tr>";
	}
	
	//Creates a closing Table Row Tag
	public void closeTableRowTag()
	{
		htmlString += "</tr>";
	}
	
	//Creates an opening Table Cell Tag
	public void openTableCellTag()
	{
		htmlString += "<td>";
	}
	
	//Creates a closing Table Cell Tag
	public void closeTableCellTag()
	{
		htmlString += "</td>";
	}
	
	//Creates a line break
	public void LineBreak()
	{
		htmlString += "<br>";
	}
	
	//Creates a label with the specified text
	public void Label(String text)
	{
		htmlString += "<label>" + text + "</label>";
	}
	
	//Creates a link with a given text
	public void Link(String link, String text)
	{
		htmlString += "<a href=" + link + '"' + ">" + text + "<a>";
	}
	
	//Creates plain text
	public void PlainText(int value)
	{
		htmlString += value;
	}
	
	//Creates plain text
	public void PlainText(String text)
	{
		htmlString += text;
	}
	
	//Returns the HTML string
	public String returnHTML()
	{
		return htmlString;
	}
	
}
