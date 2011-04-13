MarkupUtils
===========
How many times, did you happen to have generating XML-Like markup from java code? This utility classes are the answer to your needs.

Example
-------
### Source code
    MarkupBuilder builder = new MarkupBuilder();
    builder.startOpenElement("div")
        .appendAttribute("class","spot")
        .endOpenElement();
    builder.appendText("It is a good Idea")
    builder.closeElement("div");

    String markup = builder.toMarkup()

### Generated markup:
    <div class="spot">It is a good Idea</div>
