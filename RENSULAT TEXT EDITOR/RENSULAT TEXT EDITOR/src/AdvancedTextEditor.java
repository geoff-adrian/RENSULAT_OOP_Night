class AdvancedTextEditor extends TextEditor {
    private String previousText;

    public AdvancedTextEditor(String initialText) {
        super(initialText);
        this.previousText = initialText;
    }

    @Override
    public void append(String newText) {
        previousText = getText();
        super.append(newText);
    }

    @Override
    public void delete(int n) {
        previousText = getText();
        super.delete(n);
    }

    public void undo() {
        setText(previousText);
    }
}