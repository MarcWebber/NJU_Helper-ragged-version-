function AppendHrefToContainer(index, name_a, name_title, name_text, name_date){
    var container = document.getElementById("container")
    var newhref = document.createElement("a")
    newhref.setAttribute("class", "pure_link")
    newhref.setAttribute("id", name_a + index)
    var new_title = document.createElement("p")
    new_title.setAttribute("class", "new_title")
    new_title.setAttribute("id", name_title + index)
    newhref.setAttribute("target", "_blank")
    newhref.appendChild(new_title)
    container.appendChild(newhref)

    var new_txt = document.createElement("p")
    new_txt.setAttribute("class", "new_text")
    new_txt.setAttribute("id", name_text + index)
    newhref.appendChild(new_txt)

    var new_time = document.createElement("p")
    new_time.setAttribute("class", "new_time")
    new_time.setAttribute("id", name_date + index)
    newhref.appendChild(new_time)

    var line_sep = document.createElement("hr")
    line_sep.setAttribute("class", "new_hr")
    container.appendChild(line_sep)
    
}